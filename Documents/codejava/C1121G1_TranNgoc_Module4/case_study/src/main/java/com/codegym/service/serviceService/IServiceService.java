package com.codegym.service.serviceService;


import com.codegym.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {

    Page<Facility> findAll(Pageable pageable);


    void save(Facility facility);
}
