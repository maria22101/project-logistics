package com.training.projectlogistics.controller;

import com.training.projectlogistics.service.AdminService;
import com.training.projectlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminCabinetController {
    private UserService userService;
    private AdminService adminService;

    @Autowired
    public AdminCabinetController(UserService userService,
                                  AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping
    public String greetAdmin(Model model) {
        return "adminCabinet/adminMain";
    }

    @GetMapping("/orders")
    public String displayOrders(Model model) {
        model.addAttribute("orders", adminService.getAllOrders());
        return "adminCabinet/orderList";
    }

    @GetMapping("/users")
    public String displayUsers(Model model) {
        model.addAttribute("users", adminService.getAllUsers());
        return "adminCabinet/userList";
    }
}
