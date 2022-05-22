package com.codegym.service.danhMuc;

import com.codegym.model.Blog;
import com.codegym.model.DanhMuc;
import com.codegym.repository.IDanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService{
    @Autowired
    private IDanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> fillAll() {
        return danhMucRepository.findAll();
    }

}
