package com.codegym.service.serviceService.Impl;

import com.codegym.model.service.RentType;
import com.codegym.repository.serviceRepository.IRentTypeRepository;
import com.codegym.service.serviceService.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
