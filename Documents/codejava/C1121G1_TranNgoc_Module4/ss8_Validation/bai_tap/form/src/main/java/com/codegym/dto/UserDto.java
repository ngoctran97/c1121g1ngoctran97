package com.codegym.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Component
public class UserDto implements Validator {
    private Integer id;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstname;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastnname;

    private String phonenumber;
    @Min(18)
    private String age;
    @Email
    private String email;

    public UserDto(Integer id, String firstname, String lastnname, String phonenumber, String age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastnname = lastnname;
        this.phonenumber = phonenumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnname() {
        return lastnname;
    }

    public void setLastnname(String lastnname) {
        this.lastnname = lastnname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phonenumber = userDto.getPhonenumber();
        ValidationUtils.rejectIfEmpty(errors, "phonenumber", "phonenumber.empty");
        if (phonenumber.length()>11 || phonenumber.length()<10){
            errors.rejectValue("phonenumber", "phonenumber.length");
        }
        if (!phonenumber.startsWith("0")){
            errors.rejectValue("phonenumber", "phonenumber.startsWith");
        }
        if (!phonenumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phonenumber", "phonenumber.matches");
        }
    }
}

