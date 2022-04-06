package com.codegym.service.Ipml;

import com.codegym.model.Photo;
import com.codegym.repository.IPhotoRepository;
import com.codegym.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService implements IPhotoService {

    @Autowired
    IPhotoRepository photoRepository;

    @Override
    public List<Photo> findAll() {

        return photoRepository.findAll();
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public Object findById(int id) {
        return photoRepository.findById(id);
    }

    @Override
    public void update(Integer id, Photo photo) {
        photoRepository.update(id, photo);
    }

    @Override
    public void remove(Integer id) {
        photoRepository.delete(id);
    }
}
