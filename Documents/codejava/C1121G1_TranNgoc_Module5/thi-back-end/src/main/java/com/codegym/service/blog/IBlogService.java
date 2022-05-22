package com.codegym.service.blog;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    Page<Blog> findAll(String keywordValue, Pageable pageable);

//    List<Blog> fillAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);
}
