package com.example.solarsync.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.solarsync.entity.SystemUser;
import com.example.solarsync.repository.SystemUserrepository;
@Service
public class AuthService {
    private final PasswordEncoder encoder;
    private final SystemUserrepository userRepo;    

    public AuthService(PasswordEncoder encoder, SystemUserrepository userRepo) {
        this.encoder = encoder;
        this.userRepo = userRepo;
    }

    public SystemUser register(SystemUser user) {
       user.setPassword(encoder.encode(user.getPassword()));
       return userRepo.save(user);
    }
    public boolean verifyPassword(String email, String password) {

    SystemUser user = userRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // System.out.println("Entered Password : " + password);
    // System.out.println("Stored Password  : " + user.getPassword());

    boolean result = encoder.matches(password, user.getPassword());

    System.out.println("Password Match : " + result);

    return result;
}
}
