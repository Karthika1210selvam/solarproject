package com.example.solarsync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.solarsync.entity.solar_site;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.SolarSiterepository;

@Service
public class SiteManagementservice {
    @Autowired
    SolarSiterepository solarrepo;
    public solar_site saveData(solar_site data){
        return solarrepo.save(data);
    }
    public List<solar_site> getAllData(){
        return solarrepo.findAll();
    }
    public solar_site getUserDetails(Long id){
        return solarrepo.findById(id).orElseThrow(() ->new DetailNotFound("Site Not Found"));
    }
    public solar_site updatedatabase(Long id,solar_site data){
        solar_site viewdata = solarrepo.findById(id).orElseThrow(() -> new DetailNotFound("Site Not Found"));
        viewdata.setSiteName(data.getSiteName());
        viewdata.setLocationcoordinates(data.getLocationcoordinates());
        viewdata.setRatedcapacityKW(data.getRatedcapacityKW());
        viewdata.setCommissionDate(data.getCommissionDate());
        viewdata.setCurrentGeneration(data.getCurrentGeneration());
        return solarrepo.save(viewdata);

    }
    public solar_site updatepatch(Long id,solar_site data){
        solar_site viewdata = solarrepo.findById(id).orElseThrow(() -> new DetailNotFound("Site Not Found"));
        if(data.getSiteName()!=null){
            viewdata.setSiteName(data.getSiteName());
        }
        if(data.getLocationcoordinates()!=null){
            viewdata.setLocationcoordinates(data.getLocationcoordinates());
        }
        if(data.getRatedcapacityKW()!=null){
            viewdata.setRatedcapacityKW(data.getRatedcapacityKW());
        }
        if(data.getCommissionDate()!=null){
            viewdata.setCommissionDate(data.getCommissionDate());
        }
        if(data.getCurrentGeneration()!=null){
            viewdata.setCurrentGeneration(data.getCurrentGeneration());
        }
        return solarrepo.save(viewdata);
    } 
    public solar_site getDelete(Long id){
        solar_site stu= solarrepo.findById(id).orElseThrow(() -> new DetailNotFound("Site Not Found"));
        return stu;
    }
}

