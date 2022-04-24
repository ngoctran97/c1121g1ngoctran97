package com.codegym.service.contractService.Impl;

import com.codegym.model.contract.AttachService;
import com.codegym.repository.contractRepository.IAttachServicesRepository;
import com.codegym.service.contractService.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServicesRepository attachServicesRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServicesRepository.findAll();
    }
}
