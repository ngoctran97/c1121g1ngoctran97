package com.codegym.service.employeeService.Impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.EmployeeRepository.IEmployeeRepository;
import com.codegym.service.employeeService.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(String employeeName, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContainingAndDeleteFlag(employeeName,false, pageable);
    }


}
