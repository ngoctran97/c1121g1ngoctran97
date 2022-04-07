package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String index(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }


    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        userDto.validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("userList", this.userService.findAll());
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.userService.save(user);
        return "redirect:/user";
    }

}
