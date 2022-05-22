package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Huong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHuongRepository extends JpaRepository<Huong, Integer> {
}
