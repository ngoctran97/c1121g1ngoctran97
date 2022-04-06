package com.codegym.controller;

import com.codegym.service.IMayTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MayTinhController {
    @Autowired
    IMayTinhService mayTinhService;

    @RequestMapping("")
    public String displayHome() {
        return "/index";
    }

    @PostMapping("/Calculate")
    public String calculate(String operator, int num1, int num2, Model model) {
        String result = mayTinhService.Calculate(num1,num2,operator);
//        String result = new MayTinhController().mayTinhService.Calculate(num1,num2,operator);
        model.addAttribute("result", result);
        return "/index";
    }


}
