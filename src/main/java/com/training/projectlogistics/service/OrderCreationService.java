package com.training.projectlogistics.service;

import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import com.training.projectlogistics.repository.WeightRateRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderCreationService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private WeightRateRepository weightRateRepository;
    private AddressRepository addressRepository;

    @Autowired
    public OrderCreationService(OrderRepository orderRepository,
                                UserRepository userRepository,
                                RouteRepository routeRepository,
                                WeightRateRepository weightRateRepository,
                                AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.weightRateRepository = weightRateRepository;
        this.addressRepository = addressRepository;
    }

    // 3 - build Order instance
    //TODO - transactional?
    public void addOrder(String username, OrderDTO orderDTO) {

        User user = userRepository.findByUsername(username).get();
        Address address = getAddressFromDB(orderDTO);
        addressRepository.save(address);

        Order order = Order.builder()
                .deliveryDate(orderDTO.getDeliveryDate())
                .route(getRouteFromDB(orderDTO))
                .weightRate(getWeightRateFromDB(orderDTO))
                .cargoType(orderDTO.getCargoType())
                .address(address)
                .user(user)
                .orderStatus(OrderStatus.OPEN)
                .sum(getSum(orderDTO))
                .build();

        orderRepository.save(order);
    }

    private BigDecimal getSum(OrderDTO orderDTO) {
        BigDecimal basicRate = routeRepository
                .findBySourceAndDestination(orderDTO.getSource(), orderDTO.getDestination())
                .get()
                .getBasicRate();

        BigDecimal weightCoefficient = getWeightRateFromDB(orderDTO).getWeightCoefficient();

        return basicRate
                .multiply(weightCoefficient)
                .setScale(2, RoundingMode.HALF_UP);
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
                .findByWeightFromIsLessThanEqualAndWeightToGreaterThanEqual(
                        orderDTO.getWeight(),
                        orderDTO.getWeight())
                .get();
    }

    //1c - get the relevant Address
    private Address getAddressFromDB(OrderDTO orderDTO) {
        return addressRepository
                .findAddressesByStreetAndHouseAndApartment(
                        orderDTO.getStreet(),
                        orderDTO.getHouse(),
                        orderDTO.getApartment())
                .orElseGet(() -> new Address(
                        orderDTO.getStreet(),
                        orderDTO.getHouse(),
                        orderDTO.getApartment()));
    }
}
