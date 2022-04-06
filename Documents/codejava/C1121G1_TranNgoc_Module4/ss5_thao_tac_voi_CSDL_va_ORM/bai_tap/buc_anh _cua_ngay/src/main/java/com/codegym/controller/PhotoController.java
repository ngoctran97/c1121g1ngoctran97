package com.codegym.controller;

import com.codegym.model.Photo;
import com.codegym.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class PhotoController {

    @Autowired
    IPhotoService photoService;
    @GetMapping("")
    public String list(Model model) {
        List<Photo> photoList = photoService.findAll();
        model.addAttribute("photoList", photoList);
        return "/list";
    }

    @GetMapping("/create")
    private String index(Model model){
        model.addAttribute("photoList",new Photo());
        return "/home";
    }

    @PostMapping("/save")
    public String save(Photo photo) {
        photoService.save(photo);
        return "redirect:/list";
    }




}
