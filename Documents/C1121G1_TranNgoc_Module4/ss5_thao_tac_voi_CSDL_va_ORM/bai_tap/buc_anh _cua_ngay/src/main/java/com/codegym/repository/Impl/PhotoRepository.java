package com.codegym.repository.Impl;

import com.codegym.model.Photo;
import com.codegym.repository.IPhotoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PhotoRepository implements IPhotoRepository {
    @Override
    public List<Photo> findAll() {
        TypedQuery<Photo> typedQuery = BaseRepository.entityManager.createQuery("select p from photo as p", Photo.class);
        return typedQuery.getResultList();
    }
}
