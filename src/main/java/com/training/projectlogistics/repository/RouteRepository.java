package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findById(Long id);
    Optional<Route> findByPointOneAndPointTwo(String pointOne, String pointTwo);
    Optional<Route> findByPointOneUAAndPointTwoUA(String pointOneUA, String pointTwoUA);
}
