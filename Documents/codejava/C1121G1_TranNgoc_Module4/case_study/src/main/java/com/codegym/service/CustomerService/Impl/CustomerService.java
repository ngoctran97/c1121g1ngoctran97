package com.codegym.service.CustomerService.Impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.ICustomerUser;
import com.codegym.repository.CustomerRepository.ICustomerRepository;
import com.codegym.service.CustomerService.ICustomerService;
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

        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(String customerName, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndDeleteFlag(customerName,false, pageable);
    }

    @Override
    public Customer findByCode(String code) {
        return customerRepository.findByCustomerCode(code);
    }

    @Override
    public Page<ICustomerUser> findAllCustomerUserPage(Pageable pageable) {
        return customerRepository.findAllCustomerUserPage(ICustomerUser.class, pageable);
    }

    @Override
    public List<Customer> fillAll() {
        return customerRepository.findAll();
    }


}
