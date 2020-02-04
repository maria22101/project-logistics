package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.DatabaseIssueException;
import com.training.projectlogistics.service.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;

import static com.training.projectlogistics.controller.TextConstants.*;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String enterRegistration(@AuthenticationPrincipal User user) {
        if (user != null) {
            SecurityContextHolder.clearContext();
        }

        return "general/registration";
    }

    @PostMapping
    public String addUser(User user, Model model)
            throws NotUniqueEmailException, DatabaseIssueException {

        registrationService.addUser(user);

        return "redirect:/login";
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    public String handleNotUniqueEmailException(NotUniqueEmailException ex,
                                                Model model) {
        model.addAttribute("errorMessage", EMAIL_EXISTS);

        return "general/error";
    }

    @ExceptionHandler(DatabaseIssueException.class)
    public String handleDatabaseIssueException(DatabaseIssueException ex,
                                               Model model) {
        model.addAttribute("errorMessage", DATABASE_ISSUE);

        return "general/error";
    }


}
