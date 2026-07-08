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

import com.example.solarsync.entity.solar_panel;
import com.example.solarsync.services.SolarPanelservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/SolarPanel")
public class Panelcontroller {

    private final  SolarPanelservices panelser;

    public Panelcontroller(SolarPanelservices panelser) {
        this.panelser = panelser;
    }

    @PostMapping("/op/postpanel")
    public solar_panel saveData(@Valid @RequestBody solar_panel data){
        return panelser.saveData(data);
    }

    @GetMapping("/all/getpanel")
    public List<solar_panel> getData(){
        return panelser.getAllData();
    }
    
    @GetMapping("/all/Getpanel/{id}")
    public solar_panel getUservalues(@PathVariable Long id){
        return panelser.getUserDetails(id);
    }
    
    @PutMapping("/op/updatepanel/{id}")
    public solar_panel updateData(@PathVariable Long id,@RequestBody solar_panel data){
        return panelser.updatedatabase(id,data);
    }
    @PatchMapping("/op/updatepatchpanel/{id}")
    public solar_panel updatedatapatch(@PathVariable Long id,@RequestBody solar_panel data){
        return panelser.updatepatch(id,data);
    }
     @DeleteMapping("/op/deletepanel/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try {
            solar_panel getData = panelser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
}
