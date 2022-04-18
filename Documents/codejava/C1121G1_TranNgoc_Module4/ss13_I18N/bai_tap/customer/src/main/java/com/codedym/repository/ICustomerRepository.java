package com.codedym.repository;

import com.codedym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//    List<Customer> search(String name);
}
