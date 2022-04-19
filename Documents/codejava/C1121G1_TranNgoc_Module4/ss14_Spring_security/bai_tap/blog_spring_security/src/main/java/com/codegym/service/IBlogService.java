package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll( Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    void remove(Integer id);

    void update(Integer id, Blog blog);

    Page<Blog> findAllByTacGia(String tieuDe, Pageable pageable);


    Page<Blog> findAllPaging(String keywordValue, Pageable pageable);

    Page<Blog> findAllByCategoryId(Integer Id, Pageable pageable);
}
