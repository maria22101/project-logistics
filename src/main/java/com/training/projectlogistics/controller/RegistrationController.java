package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.unility.RegistrationFormValidator;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.training.projectlogistics.constants.TextConstants.*;

@Slf4j
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
            throws NotUniqueEmailException,
                   DatabaseFetchException,
                   DatabaseSaveException {

        log.info("inside RegistrationController, inside addUser() before validation");

        registrationFormValidator.validate(user, result);
        if (result.hasErrors()) {
            log.info("inside RegistrationController, inside addUser(): checked that form has errors");
            return "general/registration";
        }

        registrationService.addUser(user);

        log.info("inside RegistrationController, inside addUser() form valid, user added");

        return "redirect:/login";
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    public String handleNotUniqueEmailException(Model model) {
        model.addAttribute("errorMessage", EMAIL_EXISTS);

        return "general/error";
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseIssueException(DatabaseFetchException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }
}
