package com.codegym.repository.CustomerRepository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndDeleteFlag(String customerName, boolean deleteflag, Pageable pageable);

    Customer findByCustomerCode(String code);
}
