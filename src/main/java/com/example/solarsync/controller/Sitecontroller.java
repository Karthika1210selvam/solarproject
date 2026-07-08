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

import com.example.solarsync.entity.solar_site;
import com.example.solarsync.services.SiteManagementservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/SolarSite")
public class Sitecontroller {
  
    private final  SiteManagementservice Solarser;
    
    public Sitecontroller(SiteManagementservice solarser) {
        Solarser = solarser;
    }
    @PostMapping("/admin/postDatasite")
    public solar_site saveData(@Valid @RequestBody solar_site data){
        return Solarser.saveData(data);
    }
    @GetMapping("/all/getsite")
    public List<solar_site> getData(){
        return Solarser.getAllData();
    }
    @GetMapping("/all/Getsite/{id}")
    public solar_site getUservalues(@PathVariable Long id){
        return Solarser.getUserDetails(id);
    }
    @PutMapping("/admin/updatesite/{id}")
    public solar_site updateData(@PathVariable Long id,@RequestBody solar_site data){
        return Solarser.updatedatabase(id,data);
    }
    @PatchMapping("/admin/updatepatchsite/{id}")
    public solar_site updatedatapatch(@PathVariable Long id,@RequestBody solar_site data){
        return Solarser.updatepatch(id,data);
    }
     @DeleteMapping("/admin/deletesite/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try {
            solar_site getData = Solarser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
}

