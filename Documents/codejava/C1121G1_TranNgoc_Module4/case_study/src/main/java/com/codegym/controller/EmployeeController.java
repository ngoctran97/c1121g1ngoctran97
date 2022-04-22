package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.user.User;
import com.codegym.service.employeeService.*;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = {"", "/list"})
    public String index(Model model,
                        @PageableDefault(value = 5) Pageable pageable,
                        @RequestParam("name") Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Employee> employeePage = this.employeeService.findAll(pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("keywordValue", keywordValue);
        return "employee/index";
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("division",divisionService.findAll());
        modelAndView.addObject("educationDegree",educationDegreeService.findAll());
        modelAndView.addObject("position",positionService.findAll());
        modelAndView.addObject("user",userService.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute EmployeeDto employeeDto,
                             BindingResult bindingResult,
                             Model model) {
        Employee employee = new Employee();
        employeeDto.validate(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<Division> divisionList = divisionService.findAll();
            model.addAttribute("divisionList",divisionList);
            List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
            model.addAttribute("educationDegreeList",educationDegreeList);
            List<Position> positionList = positionService.findAll();
            model.addAttribute("positionList",positionList);
            List<User> userList = userService.findAll();
            model.addAttribute("userList",userList);
            model.addAttribute("employeeDto", employeeDto);
            return "employee/create";
        }
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public  String updatefrom(@PathVariable Integer id, Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = employeeService.findById(id);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList",divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList",educationDegreeList);

    }


}
