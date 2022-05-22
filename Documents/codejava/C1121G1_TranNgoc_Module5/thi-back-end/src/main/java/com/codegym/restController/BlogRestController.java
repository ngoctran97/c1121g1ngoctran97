package com.codegym.restController;

import com.codegym.dto.BlogDto;
import com.codegym.model.*;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.dangTin.IDangTinService;
import com.codegym.service.danhMuc.IDanhMucService;
import com.codegym.service.vungMien.IVungMienService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IDangTinService dangTinService;
    @Autowired
    private IDanhMucService danhMucService;
    @Autowired
    private IVungMienService vungMienService;

//    @GetMapping("/blog")
//    public ResponseEntity<List<Blog>> getBlogList() {
//        List<Blog> blogList = blogService.fillAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> getAllListTicket(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,10);

        Page<Blog> blogPage = this.blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Map<String, String>> saveArticle(@Valid @RequestBody BlogDto blogDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Blog blog = new Blog();
        DangTin dangTin = new DangTin();
        DanhMuc danhMuc = new DanhMuc();
        Huong huong = new Huong();
        VungMien vungMien = new VungMien();
        BeanUtils.copyProperties(blogDto, blog);
        BeanUtils.copyProperties(blogDto.getDangTinDto(), dangTin);
        BeanUtils.copyProperties(blogDto.getDanhMucDto(), danhMuc);
        BeanUtils.copyProperties(blogDto.getHuongDto(), huong);
        BeanUtils.copyProperties(blogDto.getVungMienDto(), vungMien);
        blog.setDangTin(dangTin);
        blog.setDanhMuc(danhMuc);
        blog.setHuong(huong);
        blog.setVungMien(vungMien);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable("id") Integer id) {
        Optional<Blog> articleOptional = blogService.findById(id);
        return articleOptional.map(article -> new ResponseEntity<>(article, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @PatchMapping(value = "update/{id}")
    public ResponseEntity<Map<String, String>> updateArticle(@PathVariable("id") Integer id,
                                                             @Valid @RequestBody BlogDto blogDto,
                                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Blog blog = new Blog();
        DangTin dangTin = new DangTin();
        DanhMuc danhMuc = new DanhMuc();
        Huong huong = new Huong();
        VungMien vungMien = new VungMien();
        BeanUtils.copyProperties(blogDto, blog);
        BeanUtils.copyProperties(blogDto.getDangTinDto(), dangTin);
        BeanUtils.copyProperties(blogDto.getDanhMucDto(), danhMuc);
        BeanUtils.copyProperties(blogDto.getHuongDto(), huong);
        BeanUtils.copyProperties(blogDto.getVungMienDto(), vungMien);
        blog.setId(id);
        blog.setDangTin(dangTin);
        blog.setDanhMuc(danhMuc);
        blog.setHuong(huong);
        blog.setVungMien(vungMien);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "delete")
    public ResponseEntity<Void> deleteArticle(@RequestBody Blog blog) {
        if (blog != null) {
            blog.setDeleteFlag(true);
            blogService.save(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
