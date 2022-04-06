package com.codegym.controller;

import com.codegym.model.Photo;
import com.codegym.service.IPhotoService;
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
@RequestMapping("/photo")
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
        return "redirect:/photo";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product", photoService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Photo photo){
        photoService.update(photo.getId(), photo);
        return "redirect:/photo";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("photo", photoService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Photo photo, RedirectAttributes redirect){
        photoService.remove(photo.getId());
        redirect.addFlashAttribute("success", "Removed photo successfully!");
        return "redirect:/photo";

    }

}
