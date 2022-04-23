package com.codegym.service.contractService;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(String keywordValue, Pageable pageable);


    void save(Contract contract);
}
