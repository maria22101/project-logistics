package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private RouteService routeService;

    @Autowired
    public MainController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String greetingAll(@AuthenticationPrincipal User user,
                              Model model) {

        if(user !=null) {
            SecurityContextHolder.clearContext();
        }

        model.addAttribute("routes", routeService.getAllRoutes());

        return "general/main";
    }

    @GetMapping("/login")
    public String enterLogin(@AuthenticationPrincipal User user,
                             Model model) {

        if(user !=null) {
            SecurityContextHolder.clearContext();
        }

        return "general/login";
    }
}
