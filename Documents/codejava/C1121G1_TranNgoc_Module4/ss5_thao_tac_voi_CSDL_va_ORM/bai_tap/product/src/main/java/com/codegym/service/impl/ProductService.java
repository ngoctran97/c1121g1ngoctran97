package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.create(product);
    }

    @Override
    public Object findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> searchName(String name) {
        return productRepository.search(name);

    }

}
