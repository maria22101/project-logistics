package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.repository.UserRepository;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public String enterRegistration(HttpServletRequest request,
                               HttpServletResponse response) {
        logoutAuthenticated(request, response);
        return "general/registration";
    }

    //TODO - setup message output when user exists
    @PostMapping
    public String addUser(User user, Model model) {
        Optional<User> userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            model.addAttribute("message", "User exists!");
            return "general/registration";
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setRole(Role.USER);
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "redirect:/login";
    }

    private void logoutAuthenticated(HttpServletRequest request,
                                     HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, auth);
            request.getSession().invalidate();
        }
    }
}
