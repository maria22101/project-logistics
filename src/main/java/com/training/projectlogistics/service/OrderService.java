package com.training.projectlogistics.service;

import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import com.training.projectlogistics.repository.WeightRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private WeightRateRepository weightRateRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        RouteRepository routeRepository,
                        WeightRateRepository weightRateRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.weightRateRepository = weightRateRepository;;
    }

// 3 - build Order instance
    public void addOrder(String username, OrderDTO orderDTO) {

        User user = userRepository.findByUsername(username).get();

        Order order = Order.builder()
                .deliveryDate(orderDTO.getDeliveryDate())
                .route(getRouteFromDB(orderDTO))
                .weightRate(getWeightRateFromDB(orderDTO))
                .orderStatus(OrderStatus.OPEN)
                .user(user)
//                .invoice(null)
                .build();

        orderRepository.save(order);
    }

    // 1a - get the relevant Route
    private Route getRouteFromDB(OrderDTO orderDTO) {
        return routeRepository
                .findBySourceAndDestination(orderDTO.getSource(), orderDTO.getDestination())
                .get();
    }

    // 1b - get the relevant WeightRate
    private WeightRate getWeightRateFromDB(OrderDTO orderDTO) {
        return weightRateRepository
                .findByWeightFromLessThanAndWeightToGreaterThan(orderDTO.getWeight(), orderDTO.getWeight())
                .get();
    }
}
