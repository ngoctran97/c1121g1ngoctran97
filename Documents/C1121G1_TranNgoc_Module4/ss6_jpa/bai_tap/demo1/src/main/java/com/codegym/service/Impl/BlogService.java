package com.codegym.service.Impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Object findById(int id) {
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
}
