package com.example.solarsync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.solarsync.entity.maintenance_ticket;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.MaintenanceTicketrepository;

@Service
public class Maintenanceservice {
    @Autowired
    MaintenanceTicketrepository Ticketrepo;
    public maintenance_ticket saveData(maintenance_ticket data){
        return Ticketrepo.save(data);
    }
    public List<maintenance_ticket> getAllData(){
        return Ticketrepo.findAll();
    }
    public maintenance_ticket getUserDetails(Long id){
        return Ticketrepo.findById(id).orElseThrow(() -> new DetailNotFound("Maintenance Details Not Found"));
    }
    public maintenance_ticket updatedatabase(Long id,maintenance_ticket data){
        maintenance_ticket viewdata = Ticketrepo.findById(id).orElseThrow(() -> new DetailNotFound("Maintenance Details Not Found"));
        viewdata.setId(data.getId());
        viewdata.setIssueDescription(data.getIssueDescription());
        viewdata.setStatus(data.getStatus());
        viewdata.setPriority(data.getPriority());   
        viewdata.setReportedAt(data.getReportedAt());
        return Ticketrepo.save(viewdata);

    }
    public maintenance_ticket updatepatch(Long id,maintenance_ticket data){
        maintenance_ticket viewdata = Ticketrepo.findById(id).orElseThrow(() -> new DetailNotFound("Maintenance Details Not Found"));
        if(data.getIssueDescription()!=null){
            viewdata.setIssueDescription(data.getIssueDescription());
        }
        if(data.getStatus()!=null){
            viewdata.setStatus(data.getStatus());
        }
        if(data.getPriority()!=null){
            viewdata.setPriority(data.getPriority());
        }
        if(data.getReportedAt()!=null){
            viewdata.setReportedAt(data.getReportedAt());
        }
        return Ticketrepo.save(viewdata);
    }        
    public maintenance_ticket getDelete(Long id){
        maintenance_ticket stu= Ticketrepo.findById(id).orElseThrow(() -> new DetailNotFound("Maintenance Detail Not Found"));
        Ticketrepo.delete(stu);
        return stu;
    }
}

