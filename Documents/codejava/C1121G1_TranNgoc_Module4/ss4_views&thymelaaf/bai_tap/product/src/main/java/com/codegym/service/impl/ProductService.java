package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static final Map<Integer , Product> productList;
    static {

        productList = new HashMap<>();
        productList.put(1,new Product(1,"Iphone 3",500,"blue","Iphone"));
        productList.put(2,new Product(2,"Iphone 5",600,"blue","Iphone"));
        productList.put(3,new Product(3,"Iphone 7",700,"blue","Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Object findById(int id) {
        return productList.get(id);

    }

    @Override
    public void update(Integer id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productList.remove(id);
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> products = new ArrayList<>(productList.values());
        List<Product> pro = new ArrayList<>();
        for (Product p:products){
            if(p.getName().contains(name)){
                pro.add(p);
            }
        }
        return pro;
    }
}
