package com.codegym.restController;

import com.codegym.model.customer.Customer;
import com.codegym.model.service.Facility;
import com.codegym.service.CustomerService.ICustomerService;
import com.codegym.service.serviceService.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ServiceRestController {
    @Autowired
    private IServiceService serviceService;

    @GetMapping("/service")
    public ResponseEntity<List<Facility>> getServiceList() {
        List<Facility> facilityList = serviceService.fillAll();
        if (facilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }
}
