package com.example.solarsync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="solar_sites")
public class solar_site {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="site name is required")
    private String siteName;
    @NotBlank(message="location is required")
    private String locationcoordinates;
    @NotNull(message="rated capacity must be required")
    private Float ratedcapacityKW;
    @NotBlank(message="commission date is required")
    @Size(min=6,max=15,message="enter correct format")
    private String commissionDate;
    @NotNull(message="current generation is required")
    private Float currentGeneration;
    public solar_site(Long id, String siteName, String locationcoordinates, Float ratedcapacityKW, String commissionDate,
            Float currentGeneration) {
        this.id = id;
        this.siteName = siteName;
        this.locationcoordinates = locationcoordinates;
        this.ratedcapacityKW = ratedcapacityKW;
        this.commissionDate = commissionDate;
        this.currentGeneration = currentGeneration;
    }
    public solar_site() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSiteName() {
        return siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public String getLocationcoordinates() {
        return locationcoordinates;
    }
    public void setLocationcoordinates(String locationcoordinates) {
        this.locationcoordinates = locationcoordinates;
    }
    public Float getRatedcapacityKW() {
        return ratedcapacityKW;
    }
    public void setRatedcapacityKW(Float ratedcapacityKW) {
        this.ratedcapacityKW = ratedcapacityKW;
    }
    public String getCommissionDate() {
        return commissionDate;
    }
    public void setCommissionDate(String commissionDate) {
        this.commissionDate = commissionDate;
    }
    public Float getCurrentGeneration() {
        return currentGeneration;
    }
    public void setCurrentGeneration(Float currentGeneration) {
        this.currentGeneration = currentGeneration;
    }


}
