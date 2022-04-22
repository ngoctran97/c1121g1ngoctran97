package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Employee;
import com.codegym.service.CustomerService.ICustomerService;
import com.codegym.service.CustomerService.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping(value = {"", "/list"})
    public String index(Model model,
                        @PageableDefault(value = 5) Pageable pageable,
                        @RequestParam("name") Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Customer> customerPage = this.customerService.findAll(keywordValue,pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("keywordValue", keywordValue);

        return "customer/index";
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute CustomerDto customerDto,
                             BindingResult bindingResult,
                             Model model) {
        Customer customer  = new Customer();
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerType",customerTypeList);
            model.addAttribute("customerDto", customerDto);
            return "customer/create";
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model){
        Customer customer = new Customer();
        customerDto.validate(customerDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList",customerTypeList);
            model.addAttribute("customerDto",customerDto);
            return "customer/edit";
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id-customer") Integer id){
        Customer customer = customerService.findById(id);
        if(customer != null){
            customer.setDeleteFlag(true);
            customerService.save(customer);
        }
        return "redirect:/customer/list";
    }


}