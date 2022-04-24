package com.codegym.service.CustomerService.Impl;

import com.codegym.model.customer.CustomerUser;
import com.codegym.repository.CustomerRepository.ICustomerUserRepository;
import com.codegym.repository.contractRepository.IAttachServicesRepository;
import com.codegym.service.CustomerService.ICustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserService implements ICustomerUserService {

    @Autowired
    private ICustomerUserRepository customerUserRepository;

    @Override
    public Page<CustomerUser> findAll(String keywordValue, Pageable pageable) {
        return customerUserRepository.findAll(pageable);
    }
}
