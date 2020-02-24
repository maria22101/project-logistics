package com.training.projectlogistics.service;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.exceptions.NotUniqueEmailException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.enums.Role;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository,
                               PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addUser(User user)
            throws NotUniqueEmailException, DatabaseSaveException {

        checkIfEmailPresent(user);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        try {
            userRepository.save(user);
        }catch (Exception ex) {
            throw new DatabaseSaveException();
        }
    }

    private void checkIfEmailPresent(User user)
            throws NotUniqueEmailException {

        if (userRepository
                .findByEmail(user.getEmail())
                .isPresent()) {
            throw new NotUniqueEmailException(user.getEmail());
        }
    }
}
