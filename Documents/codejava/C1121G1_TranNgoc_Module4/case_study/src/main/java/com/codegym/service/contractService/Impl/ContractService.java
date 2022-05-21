package com.codegym.service.contractService.Impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contractRepository.IContractRepository;
import com.codegym.service.contractService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(String keywordValue, Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> fillAll() {
        return this.contractRepository.findAll();
    }


}
