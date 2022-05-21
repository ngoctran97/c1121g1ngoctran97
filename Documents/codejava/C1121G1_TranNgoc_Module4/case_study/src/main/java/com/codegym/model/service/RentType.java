package com.codegym.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    private Double rentTypeCost;

    @JsonBackReference
    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Facility> serviceSet;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Facility> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Facility> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
