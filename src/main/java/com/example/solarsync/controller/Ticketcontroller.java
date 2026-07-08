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

import com.example.solarsync.entity.maintenance_ticket;
import com.example.solarsync.services.Maintenanceservice;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/MaintenanceTicket")
public class Ticketcontroller {
   
    private final Maintenanceservice Ticketser;
    
    public Ticketcontroller(Maintenanceservice ticketser) {
        Ticketser = ticketser;
    }
    @PostMapping("/op/postDataticket")
    public maintenance_ticket saveData(@Valid @RequestBody maintenance_ticket data){
        return Ticketser.saveData(data);
    }
    @GetMapping("/all/getticket")
    public List<maintenance_ticket> getData(){
        return Ticketser.getAllData();
    }
    @GetMapping("/all/Getticket/{id}")
    public maintenance_ticket getUservalues(@PathVariable Long id){
        return Ticketser.getUserDetails(id);
    }
    @PutMapping("/tech/updateticket/{id}")
    public maintenance_ticket updateData(@PathVariable Long id,@RequestBody maintenance_ticket data){
        return Ticketser.updatedatabase(id,data);
    }
    @PatchMapping("/tech/updatepatchticket/{id}")
    public maintenance_ticket updatedatapatch(@PathVariable Long id,@RequestBody maintenance_ticket data){
        return Ticketser.updatepatch(id,data);
    }
     @DeleteMapping("/op/deleteticket/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try {
            maintenance_ticket getData = Ticketser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
}

