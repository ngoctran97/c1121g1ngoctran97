package com.codegym.repository.Impl;

import com.codegym.model.Photo;
import com.codegym.repository.IPhotoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepository implements IPhotoRepository {
    @Override
    public List<Photo> findAll() {

        return null;
    }
}
