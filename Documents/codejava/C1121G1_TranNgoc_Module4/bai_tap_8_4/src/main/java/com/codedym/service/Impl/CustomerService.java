package com.codedym.service.Impl;

import com.codedym.model.Customer;
import com.codedym.repository.ICustomerRepository;
import com.codedym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Object findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Integer customerId, Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Integer customerId) {
        this.customerRepository.deleteById(customerId);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> searchName(String name) {
        return this.customerRepository.search(name);
    }


}
