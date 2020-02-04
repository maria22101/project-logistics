package com.training.projectlogistics.service;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    public RegistrationService(UserRepository userRepository,
                               PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addUser(User user) throws NotUniqueEmailException, DatabaseIssueException {

        if (userRepository
                .findByEmail(user.getEmail())
                .isPresent()) {
            throw new NotUniqueEmailException(user.getEmail());
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        try {
            userRepository.save(user);
        }catch (Exception ex) {
            throw new DatabaseIssueException("Database issue");
        }

    }
}
