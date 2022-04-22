package com.codegym.service.employeeService.Impl;

import com.codegym.model.user.User;
import com.codegym.repository.EmployeeRepository.IUserRepository;
import com.codegym.service.employeeService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
