package com.training.projectlogistics.service;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.dto.UsersDTO;
import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO - check for an empty result
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Role getUserRole(String username) {
        return userRepository.findByUsername(username).get().getRole();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return user.get();
    }
}
