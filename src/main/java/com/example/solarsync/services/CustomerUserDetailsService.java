package com.example.solarsync.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.solarsync.entity.SystemUser;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.SystemUserrepository;
@Service
public class CustomerUserDetailsService implements UserDetailsService{
     @Autowired
    SystemUserrepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      SystemUser user = userRepo.findByEmail(email).orElseThrow(() -> new DetailNotFound("User not Found"));

      return User.builder()
             .username(user.getEmail())
             .password(user.getPassword())
             .roles(user.getRole().name())
             .build();
    }
    
}
