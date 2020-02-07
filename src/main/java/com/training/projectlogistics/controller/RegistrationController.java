package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.unility.RegistrationFormValidator;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.exceptions.DatabaseIssueException;
import com.training.projectlogistics.exceptions.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.training.projectlogistics.constants.TextConstants.*;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    private RegistrationFormValidator registrationFormValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService,
                                  RegistrationFormValidator registrationFormValidator) {
        this.registrationService = registrationService;
        this.registrationFormValidator = registrationFormValidator;
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
                          BindingResult result)
            throws NotUniqueEmailException, DatabaseIssueException {

        registrationFormValidator.validate(user, result);
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
