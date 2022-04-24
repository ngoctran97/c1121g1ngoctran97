package com.codegym.service.CustomerService.Impl;

import com.codegym.model.customer.CustomerType;
import com.codegym.repository.CustomerRepository.ICustomerTypeRepository;
import com.codegym.service.CustomerService.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;


    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
