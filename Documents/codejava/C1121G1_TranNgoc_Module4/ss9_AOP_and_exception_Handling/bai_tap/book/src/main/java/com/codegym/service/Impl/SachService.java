package com.codegym.service.Impl;

import com.codegym.model.Sach;
import com.codegym.repository.ISachRepository;
import com.codegym.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SachService implements ISachService {

    @Autowired
    private ISachRepository sachRepository;
    @Override
    public List<Sach> findAll() {
        return this.sachRepository.findAll();
    }

    @Override
    public Sach findById(Integer id) {
        return sachRepository.findById(id).orElse(null);
    }

    @Override
    public void rent(Integer id) {
        sachRepository.rent(id);
    }
}
