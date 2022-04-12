package com.codegym.controller;

import com.codegym.model.HocSinh;
import com.codegym.model.Muon;
import com.codegym.model.Sach;
import com.codegym.service.IHocSinhService;
import com.codegym.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "sach")
public class SachController {

    @Autowired
    private ISachService sachService;

    @Autowired
    private IHocSinhService hocSinhService;



    @GetMapping("")
    private String index(Model model){
        List<Sach> sachList = this.sachService.findAll();
        model.addAttribute("sachList", sachList);
        List<HocSinh> hocSinhList = this.hocSinhService.findAll();
        model.addAttribute("hocSinhList",hocSinhList);
        return "muon/sachlist";
    }




}
