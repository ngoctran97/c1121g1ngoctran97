package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String name, Pageable pageable);

    void save(Blog blog);

    Object findById(int id);

    void remove(Integer id);

    void update(Integer id, Blog blog);


}
