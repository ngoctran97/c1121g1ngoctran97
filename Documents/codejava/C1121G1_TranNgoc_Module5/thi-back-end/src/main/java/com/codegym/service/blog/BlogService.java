package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public Page<Blog> findAll(String keywordValue, Pageable pageable) {
//        return this.blogRepository.findAll(pageable);
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

//    @Override
//    public List<Blog> fillAll() {
//        return blogRepository.findAll();
//    }
}
