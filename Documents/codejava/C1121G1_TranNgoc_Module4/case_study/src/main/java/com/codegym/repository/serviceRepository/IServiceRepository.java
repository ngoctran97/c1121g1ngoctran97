package com.codegym.repository.serviceRepository;

import com.codegym.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAll(Pageable pageable);
}
