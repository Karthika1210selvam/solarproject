package com.example.solarsync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="maintenance")
public class maintenance_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueDescription;
    @NotBlank(message="status is required")
    private String status;
    @NotBlank(message="priority is required")
    private String priority;
    @NotBlank(message="reported date is required")
    @Size(min=6,max=15,message="enter a correct format")
    private String reportedAt;
    public maintenance_ticket(Long id, String issueDescription, String status, String priority, String reportedAt) {
        this.id = id;
        this.issueDescription = issueDescription;
        this.status = status;
        this.priority = priority;
        this.reportedAt = reportedAt;
    }
    public maintenance_ticket() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIssueDescription() {
        return issueDescription;
    }
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getReportedAt() {
        return reportedAt;
    }
    public void setReportedAt(String reportedAt) {
        this.reportedAt = reportedAt;
    }
}
