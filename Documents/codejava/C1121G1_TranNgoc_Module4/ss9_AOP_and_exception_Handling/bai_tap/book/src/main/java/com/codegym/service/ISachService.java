package com.codegym.service;

import com.codegym.model.Sach;

import java.util.List;

public interface ISachService {
    List<Sach> findAll();

    Sach findById(Integer id);

    void rent(Integer id);
}
