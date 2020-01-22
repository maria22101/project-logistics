package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderNumber(Long orderNumber);
    List<Order> findOrdersByOrderStatus(OrderStatus status);
    List<Order> findOrdersByUser(User user);
}