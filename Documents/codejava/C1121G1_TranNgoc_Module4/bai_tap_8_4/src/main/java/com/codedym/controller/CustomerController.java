package com.codedym.controller;

import com.codedym.dto.CustomerDto;
import com.codedym.model.Customer;
import com.codedym.service.ICustomerService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    public ICustomerService customerService;


    @GetMapping(value = {"", "list"})
    public String index(Model model,
                        @PageableDefault(value = 2) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Customer> customerPage = this.customerService.findAll(pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("keywordValue", keywordValue);
        return "customer/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getCustomerId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getCustomerId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/customer";

    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute CustomerDto customerDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        return "redirect:/customer/list";
    }

}
