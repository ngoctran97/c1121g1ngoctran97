package com.codegym.restController;

import com.codegym.model.customer.Customer;
import com.codegym.service.CustomerService.ICustomerService;
import com.codegym.service.CustomerService.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customerList = customerService.fillAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
