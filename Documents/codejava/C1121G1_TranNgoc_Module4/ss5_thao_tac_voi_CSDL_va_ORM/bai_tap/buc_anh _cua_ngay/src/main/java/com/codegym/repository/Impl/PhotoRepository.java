package com.codegym.repository.Impl;

import com.codegym.model.Photo;
import com.codegym.repository.IPhotoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PhotoRepository implements IPhotoRepository {
    @Override
    public List<Photo> findAll() {
        TypedQuery<Photo> typedQuery = BaseRepository.entityManager.createQuery("select p from photo as p", Photo.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Photo photo) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(photo);
        entityTransaction.commit();
    }

    @Override
    public Object findById(int id) {
        List<Photo> photoList = new ArrayList<>();
        for (Photo photo : photoList) {
            if (photo.getId() == id) {
                return photoList.get(id);
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, Photo photo) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(photo);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        entityTransaction.commit();
    }
}
