package com.codegym.service.contractService;

import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {

    Page<ContractDetail> findAll(String keywordValue, Pageable pageable);

    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
