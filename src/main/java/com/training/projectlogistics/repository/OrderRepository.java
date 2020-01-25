package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByOrderNumber(Long orderNumber);
    List<Order> findOrdersByOrderStatus(OrderStatus status);
    List<Order> findOrdersByUser_Username(String username);
    List<Order> findOrdersByOrderStatusAndUser_Username(OrderStatus status, String username);
}