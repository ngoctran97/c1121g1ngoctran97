package com.codegym.service.contractService;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(String keywordValue, Pageable pageable);

    List<Contract> findAll();

    void save(Contract contract);

    List<Contract> fillAll();
}
