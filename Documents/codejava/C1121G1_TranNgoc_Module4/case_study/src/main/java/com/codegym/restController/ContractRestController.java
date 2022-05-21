package com.codegym.restController;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.service.CustomerService.ICustomerService;
import com.codegym.service.contractService.IContractService;
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
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping("/contract")
    public ResponseEntity<List<Contract>> getContractList() {
        List<Contract> contractList = contractService.fillAll();
        if (contractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }
}
