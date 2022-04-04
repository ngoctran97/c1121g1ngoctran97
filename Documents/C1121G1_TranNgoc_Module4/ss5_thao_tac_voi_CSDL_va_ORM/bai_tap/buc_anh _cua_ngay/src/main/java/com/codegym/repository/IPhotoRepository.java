package com.codegym.repository;

import com.codegym.model.Photo;

import java.util.List;

public interface IPhotoRepository {
    List<Photo> findAll();
}
