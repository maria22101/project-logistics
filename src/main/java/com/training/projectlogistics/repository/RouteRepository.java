package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findById(Long id);
    Optional<Route> findByPointOneAndPointTwoOrPointTwoAndPointOne(
            String city1, String city2, String city3, String city4);
    List<Route> findAll();
}
