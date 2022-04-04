package com.controller;

import com.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    IMoneyService moneyService;

    @GetMapping("/show")
    public String showIndex(){
        return "index";
    }

    @PostMapping("/action")
    public String money(@RequestParam int usd, Model model){
        int vnd = moneyService.convert(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "money";
    }
}
