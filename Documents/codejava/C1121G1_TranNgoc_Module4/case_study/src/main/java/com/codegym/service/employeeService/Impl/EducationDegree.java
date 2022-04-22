package com.codegym.service.employeeService.Impl;

import com.codegym.repository.EmployeeRepository.IEducationDegreeRepository;
import com.codegym.service.employeeService.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegree implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;


    @Override
    public List<com.codegym.model.employee.EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
