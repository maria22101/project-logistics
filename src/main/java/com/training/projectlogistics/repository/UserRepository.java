package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findUsersByRole(Role role);
}
