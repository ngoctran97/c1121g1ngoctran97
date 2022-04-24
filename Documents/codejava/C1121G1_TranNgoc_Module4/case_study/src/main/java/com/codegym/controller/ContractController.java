package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Facility;
import com.codegym.service.CustomerService.ICustomerService;
import com.codegym.service.contractService.IContractDetailService;
import com.codegym.service.contractService.IContractService;
import com.codegym.service.contractService.Impl.ContractService;
import com.codegym.service.employeeService.IEmployeeService;
import com.codegym.service.serviceService.IServiceService;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping(value = {"", "/list"})
    public String index(Model model,
                        @PageableDefault(value = 5) Pageable pageable,
                        @RequestParam("name") Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Contract> contractPage = contractService.findAll(keywordValue,pageable);
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("keywordValue", keywordValue);

        return "contract/index";
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        modelAndView.addObject("contractDetail",contractDetailService.findAll());
        modelAndView.addObject("customers",customerService.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        modelAndView.addObject("services",serviceService.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute ContractDto contractDto,
                             BindingResult bindingResult,
                             Model model) {
        Contract contract = new Contract();
        contractDto.validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<ContractDetail> contractDetailList = contractDetailService.findAll();
            model.addAttribute("contractDetail",contractDetailList);

            List<Customer> customerList = customerService.findAll();
            model.addAttribute("customer",customerList);
            List<Employee> employeeList = employeeService.findAll();
            model.addAttribute("employee", employeeList);
            List<Facility> facilityList= serviceService.findAll();
            model.addAttribute("service",facilityList);
            model.addAttribute("contractDto", contractDto);
            return "contract/create";
        }
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        return "redirect:/contract/list";
    }




}
