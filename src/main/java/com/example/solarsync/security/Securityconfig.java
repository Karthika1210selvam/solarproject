package com.example.solarsync.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.solarsync.services.CustomerUserDetailsService;
import com.example.solarsync.util.JwtFilter;
@Configuration
@EnableWebSecurity
public class Securityconfig {
    private final JwtFilter jwtFilter;
    @Autowired
    CustomerUserDetailsService userDetailsService;

    Securityconfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(10);
    }
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    @Bean
    AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(encoder());
        return provider;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf->csrf.disable())
        .cors(cors -> {}) 
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider()) 
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers("/auth/**").permitAll()
        .requestMatchers("/EnergyMetric/all/**").permitAll()
        .requestMatchers("/MaintenanceTicket/all/**").permitAll()
        .requestMatchers("/SolarPanel/all/**").permitAll()
        .requestMatchers("/SolarSite/all/**").permitAll()
        .requestMatchers("/SystemUser/**").hasRole("ADMIN")
        .requestMatchers("/SolarSite/admin/**").hasRole("ADMIN")
        .requestMatchers("/SolarPanel/op/**").hasRole("OPERATOR")
        .requestMatchers("/EnergyMetric/op/**").hasRole("OPERATOR")
        .requestMatchers("/MaintenanceTicket/op/**").hasRole("TECHNICIAN")
        .anyRequest().authenticated())
        .httpBasic(httpBasic -> httpBasic.disable())
        .formLogin(form->form.disable())
        .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
        .build();
    }
    
}
