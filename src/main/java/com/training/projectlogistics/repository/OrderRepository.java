package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderNumber(Long orderNumber);
}