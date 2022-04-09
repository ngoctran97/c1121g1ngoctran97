package com.codedym.service;

import com.codedym.model.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISavingService {
    List<Saving> fandAll();

    Page<Saving> findAll(Pageable pageable);

    Saving findById(int id);

    void update(Integer savingId, Saving saving);

    void save(Saving saving);
}
