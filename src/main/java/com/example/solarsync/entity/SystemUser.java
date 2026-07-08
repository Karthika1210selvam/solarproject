package com.example.solarsync.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="system_usesr")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Min(value=1,message="id must be greater than 1")
    //@Max(value=100000,message="id must be less tha 1 lakh")
    private Long id;
    @NotBlank(message="user name is required")
    private String username;
    @NotBlank(message="password is required")
    private String password;
    @NotBlank(message="email is not blank")
    private String email;
     @Enumerated(EnumType.STRING)
    private Role role;
    public SystemUser(Long id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public SystemUser() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public enum Role {
       ADMIN,
       OPERATOR,
       TECHNICIAN
    }


}
