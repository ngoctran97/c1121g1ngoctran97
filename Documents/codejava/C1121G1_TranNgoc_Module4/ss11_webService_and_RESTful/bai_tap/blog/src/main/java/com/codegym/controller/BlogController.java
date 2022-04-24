package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = {"","list"})
    public String index(Model model,
                        @PageableDefault(value = 2) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.blogService.findAll(pageable);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("keywordValue",keywordValue);
        return "blog/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);

        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/blog";

    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(value = 2) Pageable pageable,
                         @RequestParam Optional<String> keyword,
                         Model model){
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.blogService.findAllByTacGia(keyword.get(),pageable);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("keywordValue",keywordValue);
        return "blog/home";
    }
}
