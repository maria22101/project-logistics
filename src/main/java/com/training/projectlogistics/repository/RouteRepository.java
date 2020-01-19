package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findById(Long id);
    Optional<Route> findBySourceAndDestination(String source, String destination);
}
