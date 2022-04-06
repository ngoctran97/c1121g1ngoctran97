package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Object findById(int id);

    void remove(Integer id);

    void update(Integer id, Blog blog);
}
