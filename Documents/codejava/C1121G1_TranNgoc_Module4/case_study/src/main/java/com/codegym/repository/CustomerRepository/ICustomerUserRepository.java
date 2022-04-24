package com.codegym.repository.CustomerRepository;

import com.codegym.model.customer.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerUserRepository extends JpaRepository<CustomerUser, Integer> {


}
