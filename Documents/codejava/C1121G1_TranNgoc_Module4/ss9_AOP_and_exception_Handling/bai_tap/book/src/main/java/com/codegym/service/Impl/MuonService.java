package com.codegym.service.Impl;

import com.codegym.model.Muon;
import com.codegym.repository.IMuonRepository;
import com.codegym.service.IMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuonService implements IMuonService {

    @Autowired
    private IMuonRepository muonRepository;
    @Override
    public List<Muon> findAll() {
        return this.muonRepository.findAll();
    }

    @Override
    public void save(Muon muon) {
        muonRepository.save(muon);
    }

    @Override
    public Muon findById(Integer id) {
        return this.muonRepository.findById(id).orElse(null);
    }
}
