package com.codegym.service.dangTin;

import com.codegym.model.Blog;
import com.codegym.model.DangTin;
import com.codegym.repository.IDangTinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangTinService implements IDangTinService{
    @Autowired
    private IDangTinRepository dangTinRepository;


    @Override
    public List<DangTin> fillAll() {
        return dangTinRepository.findAll();
    }
}
