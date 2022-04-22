package com.codegym.service.employeeService.Impl;

import com.codegym.model.employee.Division;
import com.codegym.repository.EmployeeRepository.IDivisionRepsitory;
import com.codegym.service.employeeService.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepsitory divisionRepsitory;

    @Override
    public List<Division> findAll() {
        return divisionRepsitory.findAll();
    }
}
