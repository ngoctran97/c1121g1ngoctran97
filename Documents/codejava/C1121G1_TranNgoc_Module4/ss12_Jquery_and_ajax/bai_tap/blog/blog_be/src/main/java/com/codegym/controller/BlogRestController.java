package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping(value = "/blogRest")
@CrossOrigin
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> goListBlog( @PageableDefault(value = 2) Pageable pageable,
                                                  @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.blogService.findAllPaging(keywordValue, pageable);
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/{id}/view")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/{id}/category")
    public ResponseEntity<Page<Blog>>  goListBlogCategory( @PageableDefault(value = 2) Pageable pageable,
                                                   @RequestParam Optional<String> keyword,@PathVariable Integer id) {
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.blogService.findAllByCategoryId(id, pageable);

        if(blogPage==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping("/blogCategory")
    public ResponseEntity<List<Category>> goListBlogCategory(){
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> searchListBlog( @PageableDefault(value = 2) Pageable pageable,
                                                  @RequestParam Optional<String> keyword) {

        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.blogService.findAllByTacGia(keywordValue, pageable);
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }









}
