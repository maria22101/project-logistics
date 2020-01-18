package com.training.projectlogistics.controller;

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

    @Autowired
    public AdminCabinetController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String greetAdmin(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "adminCabinet";
    }
}
