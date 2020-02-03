package com.training.projectlogistics.controller;

import com.training.projectlogistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    private RouteService routeService;

    @Autowired
    public MainController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String greetingAll(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model) {

        logoutIfAuthenticated(request, response);
        model.addAttribute("routes", routeService.getAllRoutes());

        return "general/main";
    }

    @GetMapping("/login")
    public String enterLogin(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model) {

        logoutIfAuthenticated(request, response);

        return "general/login";
    }

    private void logoutIfAuthenticated(HttpServletRequest request,
                                     HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, auth);
            request.getSession().invalidate();
        }
    }
}
