package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public String registration() {
        return "registration";
    }

    //TODO - setup message output when user exists
    @PostMapping
    public String addUser(User user, Model model) {
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setRole(Role.USER);
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "redirect:/login";
    }
}
