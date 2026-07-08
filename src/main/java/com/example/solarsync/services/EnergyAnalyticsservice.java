package com.example.solarsync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.solarsync.entity.energy_metric;
import com.example.solarsync.exception.DetailNotFound;
import com.example.solarsync.repository.EnergyMetricrepository;

@Service
public class EnergyAnalyticsservice {
    @Autowired
    EnergyMetricrepository Mrepo;
    public energy_metric saveData(energy_metric data){
        return Mrepo.save(data);
    }
    public List<energy_metric> getAllData(){
        return Mrepo.findAll();
    }
    public energy_metric getUserDetails(Long id){
        return Mrepo.findById(id).orElseThrow(() -> new DetailNotFound("Metrics Not Found"));
    }
    public energy_metric updatedatabase(Long id,energy_metric data){
        energy_metric viewdata = Mrepo.findById(id).orElseThrow(() -> new DetailNotFound("Metrics Not Found"));
        viewdata.setId(data.getId());
        viewdata.setGenerationKwh(data.getGenerationKwh());
        viewdata.setGridConsumptionKwh(data.getGridConsumptionKwh());
        return Mrepo.save(viewdata);

    }
    public energy_metric updatepatch(Long id,energy_metric data){
        energy_metric viewdata = Mrepo.findById(id).orElseThrow(() -> new DetailNotFound("Metrics Not Found"));
        if(data.getGenerationKwh()!=null){
            viewdata.setGenerationKwh(data.getGenerationKwh());
        }
        if(data.getGridConsumptionKwh()!=null){
            viewdata.setGridConsumptionKwh(data.getGridConsumptionKwh());
        }
        return Mrepo.save(viewdata);
    }
    public energy_metric getDelete(Long id){
        energy_metric stu= Mrepo.findById(id).orElseThrow(() -> new DetailNotFound("Metrics Not Found"));
        Mrepo.delete(stu);
        return stu;     
    }
}
