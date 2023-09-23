package com.example.cinema.controller;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;


@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index() {
        return "adminHtml/admin";
    }

    @GetMapping("staffList")
    public String listCustomer(Model model)
    {
        List<UserEntity> customers = userService.getCustomers();
        model.addAttribute("users",customers);
        return "adminHtml/adminAccount";
    }

    @GetMapping("addStaff")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user",user);
        return "adminHtml/addStaff";
    }
    @PostMapping("addStaff")
    public String creatUser(@ModelAttribute User user, Model model) {
        Long id = userService.createUser(user);
        user.setId(id);
        model.addAttribute("user", user);
        return "redirect:/admin/staffList";
    }

    @GetMapping("editStaff/{id}")
    public String showEditCustomerForm(@PathVariable Long id, Model model) {
        // Lấy thông tin khách hàng từ cơ sở dữ liệu theo customerId
        UserEntity userEntity = userService.getUserById(id);

        model.addAttribute("user", userEntity);
        return "adminHtml/editStaff"; // Trả về tên trang chỉnh sửa
    }

    @PostMapping("saveEditedStaff")
    public String saveEditedCustomer(@ModelAttribute("customer") User user) throws UserPrincipalNotFoundException {
        // Gọi dịch vụ để cập nhật thông tin khách hàng vào cơ sở dữ liệu
        userService.updateUser(user);
        return "redirect:/admin/staffList"; // Chuyển hướng đến danh sách khách hàng hoặc trang khác
    }

    @GetMapping("/deleteStaff/{id}")
    public String deleteCustomer(@PathVariable Long id) throws UserPrincipalNotFoundException {
        // Gọi dịch vụ để xóa khách hàng từ cơ sở dữ liệu
        userService.deleteUser(id);
        return "redirect:/admin/staffList"; // Chuyển hướng đến danh sách khách hàng hoặc trang khác
    }
}
