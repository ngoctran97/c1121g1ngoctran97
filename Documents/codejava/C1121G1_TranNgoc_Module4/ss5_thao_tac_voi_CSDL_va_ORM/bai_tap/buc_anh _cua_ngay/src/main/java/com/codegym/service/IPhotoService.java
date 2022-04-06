package com.codegym.service;

import com.codegym.model.Photo;

import java.util.List;

public interface IPhotoService {
    List<Photo> findAll();

    void save(Photo photo);

    Object findById(int id);

    void update(Integer id, Photo photo);

    void remove(Integer id);
}
