package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll( Pageable pageable);

    void save(Blog blog);

    Object findById(int id);

    void remove(Integer id);

    void update(Integer id, Blog blog);


}
