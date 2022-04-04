package com.controller;

import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("")
    private String ShowIndex(){
        return "index";
    }

    @PostMapping("/translate")
    private String translate(@RequestParam String txtSearch, Model model){
        Map<String,String> ten = dictionaryService.translate();
        String result = ten.get(txtSearch);
        if(result == null){
            model.addAttribute("msg","khong tim thay");
        }else {
            model.addAttribute("result", result);
        }
        return "index";
    }

}
