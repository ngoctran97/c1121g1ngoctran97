package com.codedym.repository;

import com.codedym.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ISavingRepositoRy extends JpaRepository<Saving, Integer> {
}
