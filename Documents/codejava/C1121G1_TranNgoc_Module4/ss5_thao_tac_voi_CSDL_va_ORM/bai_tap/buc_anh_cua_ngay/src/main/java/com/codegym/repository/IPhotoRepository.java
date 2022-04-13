package com.codegym.repository;

import com.codegym.model.Photo;

import java.util.List;

public interface IPhotoRepository {
    List<Photo> findAll();

    void save(Photo photo);

    Object findById(int id);

    void update(Integer id, Photo photo);

    void delete(Integer id);
}
