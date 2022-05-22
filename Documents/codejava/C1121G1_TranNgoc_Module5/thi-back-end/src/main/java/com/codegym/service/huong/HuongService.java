package com.codegym.service.huong;

import com.codegym.model.Blog;
import com.codegym.model.Huong;
import com.codegym.repository.IHuongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuongService implements IHuongService{
    private IHuongRepository huongRepository;


    @Override
    public List<Huong> fillAll() {
        return huongRepository.findAll();
    }
}
