package com.training.projectlogistics.service;

import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderCreationService {
    private static BigDecimal WEIGHT_LIGHT_LOWER_BOUND = new BigDecimal("0.01");
    private static BigDecimal WEIGHT_LIGHT_UPPER_BOUND = new BigDecimal("5.00");
    private static BigDecimal WEIGHT_MEDIUM_LOWER_BOUND = new BigDecimal("5.01");
    private static BigDecimal WEIGHT_MEDIUM_UPPER_BOUND = new BigDecimal("10.00");
    private static BigDecimal WEIGHT_HEAVY_LOWER_BOUND = new BigDecimal("10.01");
    private static BigDecimal WEIGHT_HEAVY_UPPER_BOUND = new BigDecimal("20.00");

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private AddressRepository addressRepository;

    @Autowired
    public OrderCreationService(OrderRepository orderRepository,
                                UserRepository userRepository,
                                RouteRepository routeRepository,
                                AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
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
                .weight(orderDTO.getWeight())
                .cargoType(orderDTO.getCargoType())
//                .address(address)
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

        return basicRate
                .multiply(getWeightRateCoefficient(orderDTO))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getWeightRateCoefficient(OrderDTO orderDTO) {
        BigDecimal weight = orderDTO.getWeight().setScale(2, RoundingMode.HALF_UP);
        BigDecimal weightRateCoefficient;
        if (weight.compareTo(WEIGHT_LIGHT_UPPER_BOUND) <= 0) {
            weightRateCoefficient = new BigDecimal("1.00");
        }else if(weight.compareTo(WEIGHT_MEDIUM_UPPER_BOUND) <= 0) {
            weightRateCoefficient = new BigDecimal("1.20");
        }else {
            weightRateCoefficient = new BigDecimal("1.50");
        }
        return weightRateCoefficient;
    }

    // 1a - get the relevant Route
    private Route getRouteFromDB(OrderDTO orderDTO) {
        return routeRepository
                .findBySourceAndDestination(orderDTO.getSource(), orderDTO.getDestination())
                .get();
    }

    // 1b - get the relevant WeightRate
//    private WeightRate getWeightRateFromDB(OrderDTO orderDTO) {
//        return weightRateRepository
//                .findByWeightFromIsLessThanEqualAndWeightToGreaterThanEqual(
//                        orderDTO.getWeight(),
//                        orderDTO.getWeight())
//                .get();
//    }

    //1c - get the relevant Address
    private Address getAddressFromDB(OrderDTO orderDTO) {
        return addressRepository
                .findAddressesByStreetAndHouseAndApartmentAndRoute(
                        orderDTO.getStreet(),
                        orderDTO.getHouse(),
                        orderDTO.getApartment(),
                        getRouteFromDB(orderDTO))
                .orElseGet(() -> new Address(
                        orderDTO.getStreet(),
                        orderDTO.getHouse(),
                        orderDTO.getApartment(),
                        getRouteFromDB(orderDTO)));
    }
}
