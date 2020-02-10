package com.training.projectlogistics.service;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
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

    public List<Order> getAllOrders()
            throws DatabaseFetchException {

        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public List<Order> getOpenOrders()
            throws DatabaseFetchException {

        try {
            return orderRepository.findOrdersByOrderStatus(OrderStatus.OPEN);
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public List<Order> getOrdersByEmail(String email)
            throws DatabaseFetchException {

        try {
            return orderRepository.findOrdersByUser_Email(email);
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public List<Order> getInvoicedOrdersByEmail(String email)
            throws DatabaseFetchException {

        try {
            return orderRepository
                    .findOrdersByOrderStatusAndUser_Email(OrderStatus.INVOICED, email);
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public Order getOrderByNumber(Long orderNumber)
            throws DatabaseFetchException {

        return orderRepository
                .findOrderByOrderNumber(orderNumber)
                .orElseThrow(DatabaseFetchException::new);
    }
}
