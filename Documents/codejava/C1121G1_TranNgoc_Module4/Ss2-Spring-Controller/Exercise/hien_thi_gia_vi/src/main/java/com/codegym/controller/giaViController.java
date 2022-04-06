package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class giaViController {
    @RequestMapping("")
    public String save() {
        return "index";
    }

    @GetMapping("save")
    public String save(@RequestParam(required = false) String[] condiment, Model model){
        model.addAttribute("condiments",condiment);
        return "/index";
    }

}
