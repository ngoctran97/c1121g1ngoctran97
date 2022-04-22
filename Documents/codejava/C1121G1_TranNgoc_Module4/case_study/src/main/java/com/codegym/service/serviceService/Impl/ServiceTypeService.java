package com.codegym.service.serviceService.Impl;

import com.codegym.model.service.ServiceType;
import com.codegym.repository.serviceRepository.IServiceTypeRepository;
import com.codegym.service.serviceService.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
