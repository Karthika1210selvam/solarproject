package com.example.solarsync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.solarsync.entity.solar_panel;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.SolarPanelrepository;

@Service
public class SolarPanelservices {
     @Autowired
     SolarPanelrepository Panelrepo;
    public solar_panel saveData(solar_panel data){
        return Panelrepo.save(data);
    }
    public List<solar_panel> getAllData(){
        return Panelrepo.findAll();
    }
    public solar_panel getUserDetails(Long id){
        return Panelrepo.findById(id).orElseThrow(() -> new DetailNotFound("Panel Not Found"));
    }
    public solar_panel updatedatabase(Long id,solar_panel data){
        solar_panel viewdata = Panelrepo.findById(id).orElseThrow(() -> new DetailNotFound("Panel Not Found"));
        viewdata.setId(data.getId());
        viewdata.setSerialNumber(data.getSerialNumber());
        viewdata.setStatus(data.getStatus());
        viewdata.setInstallationDate(data.getInstallationDate());
        viewdata.setUsageCount(data.getUsageCount());
        return Panelrepo.save(viewdata);

    }
    public solar_panel updatepatch(Long id,solar_panel data){
        solar_panel viewdata = Panelrepo.findById(id).orElseThrow(() -> new DetailNotFound("Panel Not Found"));
        if(data.getSerialNumber()!=null){
            viewdata.setSerialNumber(data.getSerialNumber());
        }
        if(data.getStatus()!=null){
            viewdata.setStatus(data.getStatus());
        }
        if(data.getInstallationDate()!=null){
            viewdata.setInstallationDate(data.getInstallationDate());
        }
        if(data.getUsageCount()!=null){
            viewdata.setUsageCount(data.getUsageCount());
        }
        return Panelrepo.save(viewdata);
    }
    public solar_panel getDelete(Long id){
        solar_panel stu= Panelrepo.findById(id).orElseThrow(() -> new DetailNotFound("Panel Not Found"));
        return stu;
    }
}
