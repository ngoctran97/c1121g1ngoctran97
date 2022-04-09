package com.codedym.service.Impl;

import com.codedym.model.Saving;
import com.codedym.repository.ISavingRepositoRy;
import com.codedym.service.ISavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingService implements ISavingService {
    @Autowired
    private ISavingRepositoRy savingRepositoRy;

    @Override
    public List<Saving> fandAll() {
        return this.savingRepositoRy.findAll();
    }

    @Override
    public Page<Saving> findAll(Pageable pageable) {
        return this.savingRepositoRy.findAll(pageable);
    }

    @Override
    public Saving findById(int id) {
        return this.savingRepositoRy.findById(id).orElse(null);
    }

    @Override
    public void update(Integer savingId, Saving saving) {
        this.savingRepositoRy.save(saving);
    }

    @Override
    public void save(Saving saving) {
        savingRepositoRy.save(saving);
    }


}
