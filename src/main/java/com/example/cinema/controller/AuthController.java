package com.example.cinema.controller;

import com.example.cinema.domain.User;
import com.example.cinema.exception.FieldMissMatchException;
import com.example.cinema.exception.FieldMissMatchException;
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
public class AuthController {

    @Autowired
    private UserService userService;

//    @GetMapping("/login")
//    public String index(){
//        return "customerHtml/login";
//    }

//    @GetMapping("signup")
//    public String register(@ModelAttribute User user, Model model) {
//        model.addAttribute("user", user);
//        return "register/registration";
//    }
//
//    @PostMapping("signup")
//    public String signup(@ModelAttribute("user") User user)
//            throws FieldMissMatchException {
//
//        userService.register(user);
//        return "redirect:/login";
//    }
}
