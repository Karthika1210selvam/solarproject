package com.example.solarsync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="energy")
public class energy_metric {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="generationKwh is required")
    private Float generationKwh;
    @NotNull(message="grid consumptionKwh is required")
    private Float gridConsumptionKwh;
    public energy_metric(Long id, Float generationKwh, Float gridConsumptionKwh) {
        this.id = id;
        this.generationKwh = generationKwh;
        this.gridConsumptionKwh = gridConsumptionKwh;
    }
    public energy_metric() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Float getGenerationKwh() {
        return generationKwh;
    }
    public void setGenerationKwh(Float generationKwh) {
        this.generationKwh = generationKwh;
    }
    public Float getGridConsumptionKwh() {
        return gridConsumptionKwh;
    }
    public void setGridConsumptionKwh(Float gridConsumptionKwh) {
        this.gridConsumptionKwh = gridConsumptionKwh;
    }

}
