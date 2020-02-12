package com.training.projectlogistics.controller;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.RouteService;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private RouteService routeService;

    @Autowired
    public MainController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String greetAll(@AuthenticationPrincipal User user,
                           Model model)
            throws DatabaseFetchException {

        if (user != null) {
            SecurityContextHolder.clearContext();
        }

        model.addAttribute("routes", routeService.getAllRoutes());
        model.addAttribute("statics", new DefaultObjectWrapperBuilder(new Version("2.3.28"))
                .build().getStaticModels());

        return "general/main";
    }

    @GetMapping("/login")
    public String enterLogin(@AuthenticationPrincipal User user,
                             Model model) {

        if (user != null) {
            SecurityContextHolder.clearContext();
        }

        return "general/login";
    }

    @GetMapping("/login/authError")
    public String failedLoginOutput() {

        return "general/authError";
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }
}
