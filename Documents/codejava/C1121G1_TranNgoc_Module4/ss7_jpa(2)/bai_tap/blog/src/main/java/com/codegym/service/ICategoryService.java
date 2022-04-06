package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
//    Category findById(Integer id);

    List<Category> findAll();

    void save(Category category);

    Object findById(Integer id);

    void remove(Integer id);
}
