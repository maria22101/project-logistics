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
    private DeliveryItemRepository deliveryItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        RouteRepository routeRepository,
                        WeightRateRepository weightRateRepository,
                        DeliveryItemRepository deliveryItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.weightRateRepository = weightRateRepository;
        this.deliveryItemRepository = deliveryItemRepository;
    }

// 3 - build Order instance
    public void addOrder(String username, OrderDTO orderDTO) {

        User user = userRepository.findByUsername(username).get();
        DeliveryItem deliveryItem = DeliveryItem.builder()
                .route(getRouteFromDB(orderDTO))
                .weightRate(getWeightRateFromDB(orderDTO))
                .build();

        deliveryItemRepository.save(deliveryItem);

        Order order = Order.builder()
                .deliveryDate(orderDTO.getDeliveryDate())
                .orderStatus(OrderStatus.OPEN)
                .user(user)
                .deliveryItem(deliveryItem)
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

    // 2 - build DeliveryItem instance
//    private DeliveryItem buildDeliveryItem(OrderDTO orderDTO) {
//        DeliveryItem deliveryItem = DeliveryItem.builder()
//                .route(getRouteFromDB(orderDTO))
//                .weightRate(getWeightRateFromDB(orderDTO))
//                .build();
//    }

    // Delivery cost calculation - to be in other service?

//    private BigDecimal getSum(OrderDTO orderDTO) {
//        BigDecimal basicRate = routeRepository
//                .findBySourceAndDestination(orderDTO.getSource(), orderDTO.getDestination())
//                .get()
//                .getBasicRate();
//        BigDecimal cargoCoefficient = cargoCostDependenceRepository
//                .getCargo_inputByCargoType(orderDTO.getCargo())
//                .get()
//                .getCargoCoefficient();
//        BigDecimal weightCoefficient = getWeightCoefficient(orderDTO);
//
//        return basicRate
//                .multiply(cargoCoefficient)
//                .multiply(weightCoefficient)
//                .setScale(2, RoundingMode.HALF_UP);
//    }
//
//    private BigDecimal getWeightCoefficient(OrderDTO orderDTO) {
//        return weightRateRepository
//                .findByWeightFromLessThanAndWeightToGreaterThan(orderDTO.getWeight(), orderDTO.getWeight())
//                .get()
//                .getWeightCoefficient();
//    }
}
