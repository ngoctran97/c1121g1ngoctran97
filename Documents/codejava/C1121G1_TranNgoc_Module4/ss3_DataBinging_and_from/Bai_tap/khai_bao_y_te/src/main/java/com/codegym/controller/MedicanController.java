package com.codegym.controller;

import com.codegym.model.Medican;
import com.codegym.service.IMedicanService;
import com.codegym.service.impl.MedicanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MedicanController {

    private final IMedicanService medicanService = new MedicanService();

    @GetMapping("")
    private String index(Model model) {
        List<Medican> medicanList = medicanService.findAll();
        model.addAttribute("medicanList", medicanList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("medican", new Medican());
        return "/create";
    }


}
