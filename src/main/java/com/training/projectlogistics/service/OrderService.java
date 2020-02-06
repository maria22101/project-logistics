package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //TODO - check for an empty result
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //TODO - check for an empty result
    public List<Order> getOpenOrders() {
        return orderRepository.findOrdersByOrderStatus(OrderStatus.OPEN);
    }

    //TODO - check for an empty result
    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findOrdersByUser_Email(email);
    }

    //TODO - check for an empty result
    public List<Order> getInvoicedOrdersByEmail(String email) {
        return orderRepository.findOrdersByOrderStatusAndUser_Email(OrderStatus.INVOICED, email);
    }

    //TODO - process null
    public Order getOrderByNumber(Long orderNumber) {
        return orderRepository.findOrderByOrderNumber(orderNumber).get();
    }
}
