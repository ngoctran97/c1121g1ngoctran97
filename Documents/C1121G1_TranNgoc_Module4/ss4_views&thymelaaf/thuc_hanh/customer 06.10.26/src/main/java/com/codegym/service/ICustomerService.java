package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Object findById(Integer id);

    void update(int id, Customer customer);

    void remove(int id);
}
