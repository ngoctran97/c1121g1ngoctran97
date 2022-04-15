package com.codegym.service.Impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll( Pageable pageable) {
        return blogRepository.findAll( pageable);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Blog blog) {

        this.blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByTacGia(String tieuDe, Pageable pageable) {
        return this.blogRepository.findAllByTacGiaContaining(tieuDe, pageable);
    }

    @Override
    public Page<Blog> findAllPaging(String keywordValue, Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Integer Id, Pageable pageable) {
        return blogRepository.findAllByCategoryId(Id, pageable);
    }
}
