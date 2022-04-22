package com.codegym.dto;

import com.codegym.model.service.RentType;
import com.codegym.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {

    private Integer serviceId;

    @NotBlank(message = "Service code can not empty")
    @Pattern(regexp = "(DV-)[0-9]{4}", message = "Service code must be in DV-XXXX format, where X is integer number.")
    private String serviceCode;

    @NotBlank(message = "Name can not empty")
    private String serviceName;

    @Min(value = 0, message = "min = 0" )
    private Integer serviceArea;

    @Min(value = 0, message = "min = 0" )
    private Double serviceCost;

    @Min(value = 0, message = "min = 0" )
    private Integer serviceMaxPeople;

    @NotBlank(message = "Standard room can not empty")
    private String standardRoom;

    @NotBlank(message = "Description Other Convenience can not empty")
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "min = 0" )
    private Double poolArea;

    @Min(value = 0, message = "min = 0" )
    private Integer numberOfFloor;

    private RentType rentType;
    private ServiceType serviceType;

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
