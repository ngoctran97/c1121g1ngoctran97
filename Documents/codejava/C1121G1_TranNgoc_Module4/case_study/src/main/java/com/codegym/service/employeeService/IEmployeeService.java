package com.codegym.service.employeeService;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();
}
