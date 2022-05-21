package com.codegym.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;
    private String serviceTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Facility> serviceSet;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Facility> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Facility> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
