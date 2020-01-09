package com.training.projectlogistics.controller;

import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }
}
