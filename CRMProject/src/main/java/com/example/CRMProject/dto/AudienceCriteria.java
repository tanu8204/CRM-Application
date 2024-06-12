package com.example.CRMProject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AudienceCriteria {

    @NotNull(message = "Audience name is required")
    private String name;

    @Min(value = 0, message = "Minimum total spend should be 0")
    private Double minTotalSpend;

    private Integer maxVisits;

    private LocalDateTime lastVisitBefore;

    // Constructors, getters, and setters

    public AudienceCriteria() {
    }

    public AudienceCriteria(String name, Double minTotalSpend, Integer maxVisits, LocalDateTime lastVisitBefore) {
        this.name = name;
        this.minTotalSpend = minTotalSpend;
        this.maxVisits = maxVisits;
        this.lastVisitBefore = lastVisitBefore;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinTotalSpend() {
        return minTotalSpend;
    }

    public void setMinTotalSpend(Double minTotalSpend) {
        this.minTotalSpend = minTotalSpend;
    }

    public Integer getMaxVisits() {
        return maxVisits;
    }

    public void setMaxVisits(Integer maxVisits) {
        this.maxVisits = maxVisits;
    }

    public LocalDateTime getLastVisitBefore() {
        return lastVisitBefore;
    }

    public void setLastVisitBefore(LocalDateTime lastVisitBefore) {
        this.lastVisitBefore = lastVisitBefore;
    }
}
