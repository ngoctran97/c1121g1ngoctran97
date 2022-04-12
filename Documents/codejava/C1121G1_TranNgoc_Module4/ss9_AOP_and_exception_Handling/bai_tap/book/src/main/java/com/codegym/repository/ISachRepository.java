package com.codegym.repository;

import com.codegym.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ISachRepository extends JpaRepository<Sach, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update sach set so_luong = so_luong - 1 where id = :id", nativeQuery = true)
    void rent(@Param("id") Integer id);

}