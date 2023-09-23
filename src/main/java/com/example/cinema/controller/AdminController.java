package com.example.cinema.controller;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        return "adminHtml/admin";
    }

    @GetMapping("customerList")
    public String listCustomer(Model model)
    {
        List<UserEntity> customers = userService.getCustomers();
        model.addAttribute("users",customers);
        return "adminHtml/adminCustomer";
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("users", new User());
        return "adminHtml/addCustomer";
    }
}
