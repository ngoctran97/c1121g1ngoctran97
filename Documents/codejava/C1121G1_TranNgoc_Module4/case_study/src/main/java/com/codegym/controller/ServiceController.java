package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.service.Facility;
import com.codegym.model.service.ServiceType;
import com.codegym.service.serviceService.IRentTypeService;
import com.codegym.service.serviceService.IServiceService;
import com.codegym.service.serviceService.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping(value = {"", "/list"})
    public String index(Model model,
                        @PageableDefault(value = 10) Pageable pageable,
                        @RequestParam("name") Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Facility> servicePage = serviceService.findAll(pageable);
        model.addAttribute("servicePage", servicePage);
        model.addAttribute("keywordValue", keywordValue);
        return "service/index";
    }

    @GetMapping("/create/{id}")
    public ModelAndView showForm(@PathVariable("id") Integer serviceTypeId) {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("rentType",rentTypeService.findAll());
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        modelAndView.addObject("serviceTypeId",serviceTypeId);
        return modelAndView;
    }

    @PostMapping("/save/{id}")
    public String createForm(@Valid @ModelAttribute ServiceDto serviceDto,
                             BindingResult bindingResult,
                             Model model,
                             @PathVariable("id") Integer serviceTypeId){
        Facility facility = new Facility();
        serviceDto.validate(serviceDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("rentType",rentTypeService.findAll());
            model.addAttribute("serviceTypeId",serviceTypeId);
            List<ServiceType> serviceTypeList = serviceTypeService.findAll();
            model.addAttribute("serviceType",serviceTypeList);
            model.addAttribute("serviceDto",serviceDto);
            return "service/create";
        }
        BeanUtils.copyProperties(serviceDto, facility);
        serviceService.save(facility);
        return "redirect:/service/list";
    }
}
