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

import static com.training.projectlogistics.constants.WebConstants.*;

@Controller
public class MainController {
    private static final String STATICS = "statics";
    private static final String DEFAULT_OBJ_WRAPPER_BUILDER_VERSION = "2.3.28";
    private static final String MAIN_PAGE = "general/main";
    private static final String LOGIN_PAGE = "general/login";
    private static final String AUTH_ERROR_PAGE = "general/authError";

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
        model.addAttribute(ATTRIBUTE_ROUTES, routeService.getAllRoutes());
        model.addAttribute(STATICS,
                new DefaultObjectWrapperBuilder(new Version(DEFAULT_OBJ_WRAPPER_BUILDER_VERSION))
                .build().getStaticModels());
        return MAIN_PAGE;
    }

    @GetMapping("/login")
    public String enterLogin(@AuthenticationPrincipal User user,
                             Model model) {
        if (user != null) {
            SecurityContextHolder.clearContext();
        }
        return LOGIN_PAGE;
    }

    @GetMapping("/login/authError")
    public String failedLoginOutput() {
        return AUTH_ERROR_PAGE;
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }
}
