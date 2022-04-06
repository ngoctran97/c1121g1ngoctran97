package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void create(Product product);

    Object findById(int id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> search(String name);
}
