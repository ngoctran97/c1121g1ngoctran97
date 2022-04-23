package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ContractDto implements Validator {
    private Integer contractId;

    @NotBlank(message = "Name can not empty")
    private String contractStartDate;

    @NotBlank(message = "Name can not empty")
    private String contractEndDate;

//    @NotBlank(message = "Name can not empty")
//    @Min(value = 0, message = "min = 0" )
//    private Double contractDeposit;
//
//    @NotBlank(message = "Name can not empty")
//    @Min(value = 0, message = "min = 0" )
//    private Double contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private Facility facility;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

//    public Double getContractDeposit() {
//        return contractDeposit;
//    }
//
//    public void setContractDeposit(Double contractDeposit) {
//        this.contractDeposit = contractDeposit;
//    }
//
//    public Double getContractTotalMoney() {
//        return contractTotalMoney;
//    }
//
//    public void setContractTotalMoney(Double contractTotalMoney) {
//        this.contractTotalMoney = contractTotalMoney;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
