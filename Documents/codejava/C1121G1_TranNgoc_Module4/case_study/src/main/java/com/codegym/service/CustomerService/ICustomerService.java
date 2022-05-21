package com.codegym.service.CustomerService;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.ICustomerUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    Page<Customer> findAll(String customerName, Pageable pageable);

    Customer findByCode(String code);

    Page<ICustomerUser> findAllCustomerUserPage(Pageable pageable);

    List<Customer> fillAll();
}
