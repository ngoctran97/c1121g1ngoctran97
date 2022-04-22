package com.codegym.service.employeeService.Impl;

import com.codegym.model.employee.Position;
import com.codegym.repository.EmployeeRepository.IPositionRepository;
import com.codegym.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;


    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
