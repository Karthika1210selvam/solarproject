package com.example.solarsync.services;

import java.security.Key;
import java.util.Date;
import java.util.List;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.solarsync.entity.SystemUser;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.SystemUserrepository;
@Service
public class Userservices {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private Long exp;
  
    @Autowired
    SystemUserrepository Userrepo;

     @Autowired
    public PasswordEncoder passwordEncoder;
    public SystemUser saveData(SystemUser data){
        String BycrpPass=passwordEncoder.encode(data.getPassword());
        data.setPassword(BycrpPass);
        return Userrepo.save(data);
    }
    public List<SystemUser> getAllData(){
        return Userrepo.findAll();
    }
    public SystemUser getUserDetails(Long id){
        return Userrepo.findById(id).orElseThrow(() -> new DetailNotFound("User Not Found"));
    }
    public SystemUser updatedatabase(Long id,SystemUser data){
        SystemUser viewdata = Userrepo.findById(id).orElseThrow(() -> new DetailNotFound("User Not Found"));
        viewdata.setId(data.getId());
        viewdata.setUsername(data.getUsername());
        viewdata.setPassword(data.getPassword());
        viewdata.setEmail(data.getEmail());
        viewdata.setRole(data.getRole());
        return Userrepo.save(viewdata);

    }
    public SystemUser updatepatch(Long id,SystemUser data){
        SystemUser viewdata = Userrepo.findById(id).orElseThrow(() -> new DetailNotFound("User Not Found"));
        if (data.getUsername() != null) {
            viewdata.setUsername(data.getUsername());
        }
        if (data.getPassword() != null) {
            viewdata.setPassword(data.getPassword());
        }
        if (data.getEmail() != null) {
            viewdata.setEmail(data.getEmail());
        }
        if (data.getRole() != null) {
            viewdata.setRole(data.getRole());
        }
        return Userrepo.save(viewdata);
    }
    public SystemUser getDelete(Long id){
        SystemUser stu= Userrepo.findById(id).orElseThrow(() -> new DetailNotFound("User Not Found"));
        Userrepo.delete(stu);
        return stu;
    }
    public String generateToken(String email){
        return Jwts.builder()
                   .subject(email)
                   .issuedAt(new Date())
                   .expiration(new Date(System.currentTimeMillis()+exp))
                   .signWith(getKeys())
                   .compact();
    }
    private Key  getKeys(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
    
}
