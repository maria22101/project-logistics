package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.NotUniqueEmailException;
import com.training.projectlogistics.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.training.projectlogistics.controller.TextConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String enterRegistration(HttpServletRequest request,
                                    HttpServletResponse response) {
        logoutIfAuthenticated(request, response);

        return "general/registration";
    }

    //TODO - setup message output when user exists
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
