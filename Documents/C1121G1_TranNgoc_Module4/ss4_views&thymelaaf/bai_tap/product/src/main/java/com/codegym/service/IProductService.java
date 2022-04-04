package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Object findById(int id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> searchName(String name);
}
