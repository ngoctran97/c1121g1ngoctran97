package com.codegym.service.serviceService.Impl;


import com.codegym.model.service.Facility;
import com.codegym.repository.serviceRepository.IServiceRepository;
import com.codegym.service.serviceService.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;


    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        serviceRepository.save(facility);
    }
}