package com.codegym.controller;

import com.codegym.model.HocSinh;
import com.codegym.model.Muon;
import com.codegym.model.Sach;
import com.codegym.service.IHocSinhService;
import com.codegym.service.IMuonService;
import com.codegym.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/muon")
public class MuonController {

    @Autowired
    private IMuonService muonService;

    @Autowired
    private ISachService sachService;

    @Autowired
    private IHocSinhService hocSinhService;

    @GetMapping("")
    public String index(Model model){
        List<Muon> muonList = this.muonService.findAll();
        model.addAttribute("muonList",muonList);
        return "muon/list";
    }

    @GetMapping("/create/{id}")
    public ModelAndView showCreate(@PathVariable Integer id) {
        Sach sach = sachService.findById(id);
        ModelAndView modelAndView = new ModelAndView("muon/create");
        List<HocSinh> hocSinhList = hocSinhService.findAll();
        modelAndView.addObject("hocSinhList",hocSinhList);
        modelAndView.addObject("sach", sach);
        modelAndView.addObject("muon", new Muon());
        return modelAndView;
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @ModelAttribute("muon") Muon muon) throws Exception {
        Sach sach = sachService.findById(id);
        muon.setSach(sach);
        muonService.save(muon);
        sachService.rent(sach.getId());
        return "redirect:/muon";
    }

    @GetMapping(value = "/detaiil")
    public  String godetailMuon(@RequestParam Integer id,
                                Model model) throws Exception {
        Muon muon = this.muonService.findById(id);
        if(muon == null){
            throw  new Exception();
        }
        model.addAttribute("muon",muon);
        return "muon/detail_muon";
    }

    @ExceptionHandler(Exception.class)
    public  String goError(){
        return "muon/error";
    }




}
