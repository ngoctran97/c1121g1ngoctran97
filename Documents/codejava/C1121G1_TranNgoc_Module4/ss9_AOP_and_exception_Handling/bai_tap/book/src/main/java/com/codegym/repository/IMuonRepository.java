package com.codegym.repository;

import com.codegym.model.Muon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMuonRepository extends JpaRepository<Muon, Integer> {
}
