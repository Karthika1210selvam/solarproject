package com.example.solarsync.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solarsync.entity.SystemUser;
import com.example.solarsync.services.Userservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/SystemUser")
public class Usercontroller {
  
   private final Userservices User;

    public Usercontroller(Userservices user) {
    User = user;
}

    @PostMapping("/op/postDataticket")
    public SystemUser saveData(@Valid @RequestBody SystemUser data){
        return User.saveData(data);
    }

    @GetMapping("/all/getuser")
    public List<SystemUser> getData(){
        return User.getAllData();
    }

    @GetMapping("/all/Getuser/{id}")
    public SystemUser getUservalues(@PathVariable Long id){
        return User.getUserDetails(id);
    }
    @PutMapping("/updateuser/{id}")
    public SystemUser updateData(@PathVariable Long id,@RequestBody SystemUser data){
        return User.updatedatabase(id,data);
    }
    @PatchMapping("/updatepatchuser/{id}")
    public SystemUser updatedatapatch(@PathVariable Long id,@RequestBody SystemUser data){
        return User.updatepatch(id,data);
    }
     @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try {
            SystemUser getData = User.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
}

