package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.unility.UserValidator;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.DatabaseIssueException;
import com.training.projectlogistics.service.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.training.projectlogistics.controller.TextConstants.*;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    private UserValidator userValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService,
                                  UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping
    public String enterRegistration(@AuthenticationPrincipal User authenticatedUser,
                                    Model model) {
        if (authenticatedUser != null) {
            SecurityContextHolder.clearContext();
        }
        model.addAttribute("user", new User());

        return "general/registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult result,
                          Model model)
            throws NotUniqueEmailException, DatabaseIssueException {

        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "general/registration";
        }

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
