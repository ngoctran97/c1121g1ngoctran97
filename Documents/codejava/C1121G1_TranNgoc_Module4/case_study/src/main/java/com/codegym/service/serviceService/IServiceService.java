package com.codegym.service.serviceService;


import com.codegym.model.customer.Customer;
import com.codegym.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {

    Page<Facility> findAll(Pageable pageable);

    List<Facility> findAll();

    void save(Facility facility);

    List<Facility> fillAll();
}
