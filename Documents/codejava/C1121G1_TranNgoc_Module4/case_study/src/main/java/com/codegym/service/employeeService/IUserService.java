package com.codegym.service.employeeService;

import com.codegym.model.user.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
