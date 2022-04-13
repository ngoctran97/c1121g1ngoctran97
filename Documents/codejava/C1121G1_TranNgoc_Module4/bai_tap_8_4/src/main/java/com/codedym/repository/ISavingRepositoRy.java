package com.codedym.repository;

import com.codedym.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ISavingRepositoRy extends JpaRepository<Saving, Integer> {
    List<Saving> findAllByCustomer_name(String name);
}
