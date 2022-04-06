package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogList = blogService.findAll();
        System.out.println(blogList);
        model.addAttribute("blogList", blogList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
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
        return "/view";
    }
}
