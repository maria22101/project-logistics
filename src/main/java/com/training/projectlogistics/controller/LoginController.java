package com.training.projectlogistics.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/userCabinet")
    public String forUser() {
        return "userCabinet";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/adminCabinet")
    public String forAdmin() {
        return "adminCabinet";
    }
}
