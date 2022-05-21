package com.codegym.model.user;

import com.codegym.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer usernameId;

    private String username;
    private String password;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<Employee> employeeSet;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoleSet;


    public User() {
    }
//
//    public Integer getUsernameId() {
//        return usernameId;
//    }
//
//    public void setUsernameId(Integer usernameId) {
//        this.usernameId = usernameId;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}