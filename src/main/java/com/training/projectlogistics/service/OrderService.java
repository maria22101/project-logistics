package com.training.projectlogistics.service;

import com.training.projectlogistics.model.*;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import com.training.projectlogistics.repository.WeightRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private WeightRateRepository weightRateRepository;
    private AddressRepository addressRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
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
    public void addOrder(String username, OrderDTO orderDTO) {

        User user = userRepository.findByUsername(username).get();
        Address address;
        if(getAddressFromDB(orderDTO) == null) {
            address = new Address(orderDTO.getStreet(), orderDTO.getHouse(), orderDTO.getApartment());
        }else {
            address = getAddressFromDB(orderDTO);
        }

        Order order = Order.builder()
                .deliveryDate(orderDTO.getDeliveryDate())
                .route(getRouteFromDB(orderDTO))
                .weightRate(getWeightRateFromDB(orderDTO))
                .cargoType(orderDTO.getCargoType())
                .address(getAddressFromDB(orderDTO))
                .orderStatus(OrderStatus.OPEN)
                .user(user)
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

    //1c - get the relevant Address
    private Address getAddressFromDB(OrderDTO orderDTO) {
        return addressRepository
                .findAddressesByStreetAndHouseAndApartment(
                        orderDTO.getStreet(),
                        orderDTO.getHouse(),
                        orderDTO.getApartment())
                .get();
    }
}
