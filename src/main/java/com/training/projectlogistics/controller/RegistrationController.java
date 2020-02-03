package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        if(user !=null) {
            SecurityContextHolder.clearContext();
        }

        return "general/registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        try {
            registrationService.addUser(user);
        } catch (NotUniqueEmailException e){
            model.addAttribute("errorMessage", EMAIL_EXISTS);
            return "general/registration";
        }

        return "redirect:/login";
    }
}
