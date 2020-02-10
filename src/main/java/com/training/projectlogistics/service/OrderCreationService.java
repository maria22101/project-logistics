package com.training.projectlogistics.service;

import com.training.projectlogistics.exceptions.DatabaseIssueException;
import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static com.training.projectlogistics.constants.BusinessInputConstants.*;
import static com.training.projectlogistics.constants.TextConstants.*;

@Slf4j
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
    public void addOrder(String email, OrderDTO orderDTO)
            throws DatabaseIssueException {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new DatabaseIssueException(DATABASE_ISSUE));


        Address dispatchAddress = defineDispatchAddress(orderDTO);
        Address deliveryAddress = defineDeliveryAddress(orderDTO);

        Order order = Order.builder()
                .user(user)
                .dispatchAddress(dispatchAddress)
                .deliveryAddress(deliveryAddress)
                .deliveryDate(orderDTO.getDeliveryDate())
                .weight(orderDTO.getWeight())
                .cargoType(orderDTO.getCargoType())
                .sum(getSum(orderDTO))
                .orderStatus(OrderStatus.OPEN)
                .route(getRouteFromDB(orderDTO))
                .build();

        addressRepository.save(dispatchAddress);
        addressRepository.save(deliveryAddress);
        orderRepository.save(order);
    }

    // 1 - get the relevant Route
    private Route getRouteFromDB(OrderDTO orderDTO)
            throws DatabaseIssueException {

        return routeRepository
                .findByPointOneAndPointTwoOrPointTwoAndPointOne
                        (orderDTO.getDispatchCity(),
                         orderDTO.getDeliveryCity(),
                         orderDTO.getDispatchCity(),
                         orderDTO.getDeliveryCity())
                .orElseThrow(() -> new DatabaseIssueException(DATABASE_ISSUE));
    }

    // 2 - check Addresses presence in DB and create those if absent

    private Optional<Address> getDispatchAddressFromDB(OrderDTO orderDTO) {
        return addressRepository
                .findAddressesByCityAndStreetAndHouseAndApartment(
                        orderDTO.getDispatchCity(),
                        orderDTO.getDispatchStreet(),
                        orderDTO.getDispatchHouse(),
                        orderDTO.getDispatchApartment());
    }

    private Optional<Address> getDeliveryAddressFromDB(OrderDTO orderDTO) {
        return addressRepository
                .findAddressesByCityAndStreetAndHouseAndApartment(
                        orderDTO.getDeliveryCity(),
                        orderDTO.getDeliveryStreet(),
                        orderDTO.getDeliveryHouse(),
                        orderDTO.getDeliveryApartment());
    }

    private Address defineDispatchAddress(OrderDTO orderDTO)
            throws DatabaseIssueException {

        return getDispatchAddressFromDB(orderDTO).orElse(
                Address.builder()
                        .city(orderDTO.getDispatchCity())
                        .street(orderDTO.getDispatchStreet())
                        .house(orderDTO.getDispatchHouse())
                        .apartment(orderDTO.getDispatchApartment())
                        .build());
    }

    private Address defineDeliveryAddress(OrderDTO orderDTO)
            throws DatabaseIssueException {

        return getDeliveryAddressFromDB(orderDTO).orElse(
                Address.builder()
                        .city(orderDTO.getDeliveryCity())
                        .street(orderDTO.getDeliveryStreet())
                        .house(orderDTO.getDeliveryHouse())
                        .apartment(orderDTO.getDeliveryApartment())
                        .build());
    }

    // getting basic rate from the Route
    private BigDecimal getSum(OrderDTO orderDTO)
            throws DatabaseIssueException {
        BigDecimal basicRate = getRouteFromDB(orderDTO)
                .getBasicRate();

        return basicRate
                .multiply(getWeightRateCoefficient(orderDTO))
                .setScale(2, RoundingMode.HALF_UP);
    }

    // defining weight coefficient from weight_rates.properties file data
    private BigDecimal getWeightRateCoefficient(OrderDTO orderDTO) {
        BigDecimal weight = orderDTO.getWeight();
        BigDecimal weightRateCoefficient;

        if (weight.compareTo(new BigDecimal(WEIGHT_LIGHT_UPPER_BOUND)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_LIGHT_COEFFICIENT);

        } else if (weight.compareTo(new BigDecimal(WEIGHT_MEDIUM_UPPER_BOUND)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_MEDIUM_COEFFICIENT);

        } else {
            weightRateCoefficient = new BigDecimal(WEIGHT_HEAVY_COEFFICIENT);
        }

        log.info("weight coefficient amounts to: " + weightRateCoefficient.toString());

        return weightRateCoefficient;
    }
}
