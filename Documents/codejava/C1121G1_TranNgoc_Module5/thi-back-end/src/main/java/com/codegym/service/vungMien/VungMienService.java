package com.codegym.service.vungMien;


import com.codegym.model.VungMien;
import com.codegym.repository.IVungMienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VungMienService implements IVungMienService {
    @Autowired
    private IVungMienRepository vungMienRepository;

    @Override
    public List<VungMien> fillAll() {
        return vungMienRepository.findAll();
    }


}
