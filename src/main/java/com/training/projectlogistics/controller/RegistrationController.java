package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.validation.RegistrationFormValidator;
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
import static com.training.projectlogistics.constants.WebConstants.ERROR_MESSAGE;
import static com.training.projectlogistics.constants.WebConstants.GENERAL_ERROR_PAGE;

@Slf4j
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final static String ATTRIBUTE_USER = "user";
    private final static String REGISTRATION_PAGE = "general/registration";
    private final static String REDIRECT_LOGIN = "redirect:/login";

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
        model.addAttribute(ATTRIBUTE_USER, new User());
        return REGISTRATION_PAGE;
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult result)
            throws NotUniqueEmailException,
                   DatabaseSaveException {

        registrationFormValidator.validate(user, result);
        if (result.hasErrors()) {
            return REGISTRATION_PAGE;
        }
        registrationService.addUser(user);
        return REDIRECT_LOGIN;
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    public String handleNotUniqueEmailException(Model model) {
        model.addAttribute(ERROR_MESSAGE, EMAIL_EXISTS);
        return GENERAL_ERROR_PAGE;
    }

    @ExceptionHandler(DatabaseSaveException.class)
    public String handleDatabaseSaveException(DatabaseSaveException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }
}
