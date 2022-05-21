package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.CustomerService.ICustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private int customerId;

    @NotBlank(message = "Customer code can not empty")
    @Pattern(regexp = "^$|(KH-)[0-9]{4}", message = "Customer code must be in KH-XXXX format, where X is integer number.")
    private String customerCode;

    @NotBlank(message = "Name can not empty")
    private String customerName;

    @NotBlank(message = "Birthday can not empty")
    private String customerBirthday;

    @NotBlank(message = "Gender can not empty")
    private String customerGender;

    @NotBlank(message = "customerIdCard can not empty")
    @Pattern(regexp = "^$|[0-9]{9}", message = "customerIdCard must have 9 numbers")
    private String customerIdCard;

    @NotBlank(message = "Phone can not empty")
    @Pattern(regexp = "^$|(09)[0-9]{8}", message = "Phone number starting with 09 and 10 numbers")
    private String customerPhone;

    @NotBlank(message = "Email can not empty")
    @Pattern(regexp = "^$|[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)", message = "Please enter the correct format")
    private String customerEmail;

    @NotBlank(message = "Address can not empty")
    private String customerAddress;

    private CustomerType customerType;
    private Boolean deleteFlag;

    private ICustomerService customerService;

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }


    public CustomerDto() {
        setDeleteFlag(false);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String currentCode = customerDto.getCustomerCode();
        Customer customer = this.customerService.findByCode(currentCode);
        if (customer != null) {
            if (customer.getCustomerCode().equals(currentCode)) {
                errors.rejectValue("customerCode", "", "Code bi trung");
            }
        }
    }

    public Boolean getDeleteFlag() {

        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
