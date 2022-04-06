package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("categiry")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    private ModelAndView listCategory() {
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;

    }

    @RequestMapping("/create")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Category category = (Category) categoryService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id) {
        categoryService.remove(id);
        return "redirect:/category";
    }


}
