package com.codegym.service;

import com.codegym.model.Muon;

import java.util.List;

public interface IMuonService {
    List<Muon> findAll();

    void save(Muon muon);

    Muon findById(Integer id);
}
