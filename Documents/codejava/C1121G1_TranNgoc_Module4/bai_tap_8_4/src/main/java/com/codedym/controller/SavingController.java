package com.codedym.controller;

import com.codedym.dto.CustomerDto;
import com.codedym.dto.SavingDto;
import com.codedym.model.Customer;
import com.codedym.model.Saving;
import com.codedym.service.ICustomerService;
import com.codedym.service.ISavingService;
import com.codedym.service.Impl.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("saving")
public class SavingController {

    @Autowired
    public ISavingService savingService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = {"", "list"})
    public String index(Model model,
                        @PageableDefault(value = 2) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
//        Page<Saving> savingPage = this.savingService.findAll(pageable);
        List<Saving> savingList = this.savingService.fandAll();
        model.addAttribute("savings", savingList);
//        model.addAttribute("customers", customerService.findAll(pageable));
        model.addAttribute("keywordValues", keywordValue);
        return "saving/index";
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("saving/create");
        modelAndView.addObject("savingDto", new SavingDto());
        modelAndView.addObject("customer", customerService.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute SavingDto savingDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        savingDto.validate(savingDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("savingDto", savingDto);
            return "saving/create";
        }
        Saving saving = new Saving();
        BeanUtils.copyProperties(savingDto, saving);
        this.savingService.save(saving);
        return "redirect:/saving/list";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        SavingDto savingDto = new SavingDto();
        Saving saving = savingService.findById(id);
        List<Customer> customerList = this.customerService.findAll();
        model.addAttribute("customerList",customerList);
        BeanUtils.copyProperties(saving, savingDto);
        model.addAttribute("savingDto", savingDto);
        return "saving/edit";
    }

    @PostMapping("/update")
    public String editEmployee(@Validated @ModelAttribute SavingDto savingDto,
                               BindingResult bindingResult, Model model) {
        Saving saving = new Saving();
        BeanUtils.copyProperties(savingDto, saving);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customer", customerService.findAll());
            return "saving/edit";
        } else {

            this.savingService.save(saving);
            model.addAttribute("message", "successfully update");
            return "redirect:/saving/list";
        }
    }

    @GetMapping(value = "/search")
    public String search(Model model,
                         @RequestParam Optional<String> name){
        String ten = name.orElse("");
        List<Saving> savingList = savingService.findAllByName(ten);
        model.addAttribute("savingList",savingList);
        return "saving/index";

}
