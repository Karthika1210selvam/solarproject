package com.example.solarsync.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solarsync.entity.energy_metric;
import com.example.solarsync.services.EnergyAnalyticsservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/EnergyMetric")
public class Metriccontroller {

    private final EnergyAnalyticsservice Mser;
    
    public Metriccontroller(EnergyAnalyticsservice mser) {
        Mser = mser;
    }
    @PostMapping("/op/postData")
    @PreAuthorize("hasRole('OPERATOR')")
    public energy_metric saveData(@Valid @RequestBody energy_metric data){
        return Mser.saveData(data);
    }
    @GetMapping("/all/get")
    public List<energy_metric> getData(){
        return Mser.getAllData();
    }
    @GetMapping("/all/Get/{id}")
    public energy_metric getUservalues(@PathVariable Long id){
        return Mser.getUserDetails(id);
    }
    @PutMapping("/op/update/{id}")
    public energy_metric updateData(@PathVariable Long id,@RequestBody energy_metric data){
        return Mser.updatedatabase(id,data);
    }
    @PatchMapping("/op/updatepatch/{id}")
    public energy_metric updatedatapatch(@PathVariable Long id,@RequestBody energy_metric data){
        return Mser.updatepatch(id,data);
    }
     @DeleteMapping("/op/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try {
            energy_metric getData = Mser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
}
