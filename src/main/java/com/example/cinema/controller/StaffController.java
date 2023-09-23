package com.example.cinema.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class StaffController {

    @GetMapping
    public String index3() {
        return "adminHtml/admin";
    }
}
