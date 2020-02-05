package com.training.projectlogistics.service;

import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderAddressDTO;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.training.projectlogistics.controller.TextConstants.*;

@Service
public class OrderCreationService {

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
    @Transactional
    public void addOrder(String email, OrderAddressDTO orderAddressDTO)
            throws DatabaseIssueException {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new DatabaseIssueException(DATABASE_ISSUE));

        Address address = getAddressFromDB(orderAddressDTO);
        addressRepository.save(address);

        Order order = Order.builder()
                .deliveryDate(orderAddressDTO.getDeliveryDate())
                .route(getRouteFromDB(orderAddressDTO))
                .weight(orderAddressDTO.getWeight())
                .cargoType(orderAddressDTO.getCargoType())
                .address(address)
                .user(user)
                .orderStatus(OrderStatus.OPEN)
                .sum(getSum(orderAddressDTO))
                .build();

        orderRepository.save(order);
    }

    // 1 - get the relevant Route
    private Route getRouteFromDB(OrderAddressDTO orderAddressDTO)
            throws DatabaseIssueException {

        return routeRepository
                .findBySourceAndDestination(orderAddressDTO.getSource(), orderAddressDTO.getDestination())
                .orElseThrow(() -> new DatabaseIssueException(DATABASE_ISSUE));
    }

    // 2 - get the relevant Address
    private Address getAddressFromDB(OrderAddressDTO orderAddressDTO)
            throws DatabaseIssueException {

        return addressRepository
                .findAddressesByStreetAndHouseAndApartmentAndRoute(
                        orderAddressDTO.getStreet(),
                        orderAddressDTO.getHouse(),
                        orderAddressDTO.getApartment(),
                        getRouteFromDB(orderAddressDTO))
                .orElse(Address.builder()
                        .street(orderAddressDTO.getStreet())
                        .house((orderAddressDTO.getHouse()))
                        .apartment(orderAddressDTO.getApartment())
                        .route(getRouteFromDB(orderAddressDTO))
                        .build());
    }

    // getting basic rate from the Route
    private BigDecimal getSum(OrderAddressDTO orderAddressDTO)
            throws DatabaseIssueException {
        BigDecimal basicRate = getRouteFromDB(orderAddressDTO)
                .getBasicRate();

        return basicRate
                .multiply(getWeightRateCoefficient(orderAddressDTO))
                .setScale(2, RoundingMode.HALF_UP);
    }

    // defining weight coefficient from weight_rates.properties file data
    private BigDecimal getWeightRateCoefficient(OrderAddressDTO orderAddressDTO) {
        BigDecimal weight = orderAddressDTO.getWeight().setScale(2, RoundingMode.HALF_UP);
        BigDecimal weightRateCoefficient;

            if (weight.compareTo(new BigDecimal(WEIGHT_LIGHT_UPPER_BOUND)) <= 0) {
                weightRateCoefficient = new BigDecimal(WEIGHT_LIGHT_COEFFICIENT);

            }else if(weight.compareTo(new BigDecimal(WEIGHT_MEDIUM_UPPER_BOUND)) <= 0) {
                weightRateCoefficient = new BigDecimal(WEIGHT_MEDIUM_COEFFICIENT);

            }else {
                weightRateCoefficient = new BigDecimal(WEIGHT_HEAVY_COEFFICIENT);
            }

            return weightRateCoefficient;
        }
}
