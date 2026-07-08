package com.example.solarsync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="solar")
public class solar_panel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="serial number is required")
    private String serialNumber;
    @NotBlank(message="status is not blank")
    private String status;
    @NotBlank(message="installation date is required")
    @Size(min=6,max=15,message="enter a correct format")
    private String installationDate;
    @Min(value=1,message="usage count must be greater than 1")
    @Max(value=10000,message="usage count must be less than 10 thousand")
    private Integer usageCount;
    public solar_panel(Long id, String serialNumber, String status, String installationDate, Integer usageCount) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.installationDate = installationDate;
        this.usageCount = usageCount;
    }
    public solar_panel() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getInstallationDate() {
        return installationDate;
    }
    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }
    public Integer getUsageCount() {
        return usageCount;
    }
    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

}
