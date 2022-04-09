package com.codedym.service;

import com.codedym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable );

    List<Customer> findAll();

    Object findById(int id);

    void update(Integer customerId, Customer customer);

    void remove(Integer customerId);

    void save(Customer customer);

    List<Customer> searchName(String name);
}
