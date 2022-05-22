package com.codegym.service.blog;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
//    Page<Blog> findAll(String keywordValue, Pageable pageable);

//    List<Blog> fillAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(Integer id);
}
