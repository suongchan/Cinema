package com.example.cinema.controller;

import com.example.cinema.domain.User;
import com.example.cinema.service.UserService;
import com.example.cinema.validator.UserRegisterValidator;
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
    private UserRegisterValidator userRegisterValidator;


    @Autowired
    private UserService userService;

    @GetMapping("signup")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user",user);
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

    @GetMapping("home_customer")
    public String index1(){
        return "user";
    }
//    @PostMapping ("/perform_login")
//    public String index2() {
//        return "user";
//    }

//    private User getUser(Long userId) {
//        User user = new User();
//        user.setId(userId);
//        user.setUsername("Name" + userId);
//        user.setAge(10);
//        user.setPhone("5445545");
//        user.setEmail("anhtuan2982001@gmail.com");
//        return user;
//    }
}
