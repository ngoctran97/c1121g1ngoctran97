package com.codegym.repository.Ipml;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product as p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Object findById(int id) {

        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Integer id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(findAll());
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
