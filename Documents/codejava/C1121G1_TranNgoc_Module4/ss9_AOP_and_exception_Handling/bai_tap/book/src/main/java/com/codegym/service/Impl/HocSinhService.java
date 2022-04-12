package com.codegym.service.Impl;

import com.codegym.model.HocSinh;
import com.codegym.repository.IHocSinhRepository;
import com.codegym.service.IHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocSinhService implements IHocSinhService {

    @Autowired
    private IHocSinhRepository iHocSinhRepository;

    @Override
    public List<HocSinh> findAll() {
        return iHocSinhRepository.findAll();
    }
}
