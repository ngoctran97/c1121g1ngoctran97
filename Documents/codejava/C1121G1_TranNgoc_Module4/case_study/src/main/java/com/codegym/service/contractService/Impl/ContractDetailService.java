package com.codegym.service.contractService.Impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contractRepository.IContractDetailRepository;
import com.codegym.service.contractService.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(String keywordValue, Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
