package com.training.projectlogistics.controller;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class MainController {
    private RouteService routeService;

    @Autowired
    public MainController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String greetingAll(@AuthenticationPrincipal User user,
                              Model model)
            throws DatabaseFetchException {

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

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseIssueException(DatabaseFetchException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }
}
