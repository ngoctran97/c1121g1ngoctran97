package com.codegym.service.CustomerService;

import com.codegym.model.customer.CustomerUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerUserService {
    Page<CustomerUser> findAll(String keywordValue, Pageable pageable);
}
