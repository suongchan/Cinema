package com.example.cinema.controller;

import com.example.cinema.domain.User;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("signup")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "register/registration";
    }

    @GetMapping("login")
    public String index(){
        return "customerHtml/login";
    }

    @PostMapping("signup")
    public String creatUser(@ModelAttribute User user, Model model) {
        Long id = userService.createUser(user);
        user.setId(id);
        model.addAttribute("user", user);
        return "redirect:/login";

    }

}
