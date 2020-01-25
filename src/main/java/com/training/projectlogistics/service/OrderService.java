package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.OrderStatus;
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
    public List<Order> getOrdersByUserName(String username) {
        return orderRepository.findOrdersByUser_Username(username);
    }

    //TODO - check for an empty result
    public List<Order> getInvoicedOrdersByUserName(String username) {
        return orderRepository.findOrdersByOrderStatusAndUser_Username(OrderStatus.INVOICED, username);
    }

    //TODO - process null
    public Order getOrderByNumber(Long orderNumber) {
        return orderRepository.findOrderByOrderNumber(orderNumber).get();
    }
}
