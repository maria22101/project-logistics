package com.training.projectlogistics.service.order;

import com.training.projectlogistics.controller.dto.OrderDTO;
import com.training.projectlogistics.enums.OrderStatus;
import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.Address;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.Route;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.repository.AddressRepository;
import com.training.projectlogistics.repository.OrderRepository;
import com.training.projectlogistics.repository.RouteRepository;
import com.training.projectlogistics.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class OrderCreationService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private AddressRepository addressRepository;
    private OrderSumCalculationService orderSumCalculationService;

    @Autowired
    public OrderCreationService(OrderRepository orderRepository,
                                UserRepository userRepository,
                                RouteRepository routeRepository,
                                AddressRepository addressRepository,
                                OrderSumCalculationService orderSumCalculationService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.addressRepository = addressRepository;
        this.orderSumCalculationService = orderSumCalculationService;
    }

    @Transactional
    public void addOrder(String email, OrderDTO orderDTO)
            throws DatabaseFetchException, DatabaseSaveException {

        Address dispatchAddress = getDispatchAddress(orderDTO);
        Address deliveryAddress = getDeliveryAddress(orderDTO);

        Order order = Order.builder()
                .user(getUserFromDB(email))
                .dispatchAddress(dispatchAddress)
                .deliveryAddress(deliveryAddress)
                .deliveryDate(orderDTO.getDeliveryDate())
                .weight(orderDTO.getWeight())
                .cargoType(orderDTO.getCargoType())
                .sum(orderSumCalculationService.calculateSum(orderDTO.getWeight(), getRouteFromDb(orderDTO)))
                .orderStatus(OrderStatus.OPEN)
                .route(getRouteFromDb(orderDTO))
                .build();

        try {
            addressRepository.save(dispatchAddress);
            addressRepository.save(deliveryAddress);
            orderRepository.save(order);
        } catch (Exception e) {
            throw new DatabaseSaveException();
        }
    }

    private User getUserFromDB(String email)
            throws DatabaseFetchException {

        return userRepository
                .findByEmail(email)
                .orElseThrow(DatabaseFetchException::new);
    }

    private Route getRouteFromDb(OrderDTO orderDTO)
            throws DatabaseFetchException {

        return routeRepository
                .findByPointOneAndPointTwoOrPointTwoAndPointOne
                        (orderDTO.getDispatchCity(),
                                orderDTO.getDeliveryCity(),
                                orderDTO.getDispatchCity(),
                                orderDTO.getDeliveryCity())
                .orElseThrow(DatabaseFetchException::new);
    }

    private Address getDispatchAddress(OrderDTO orderDTO) {
        return Address.builder()
                .city(orderDTO.getDispatchCity())
                .street(orderDTO.getDispatchStreet())
                .house(orderDTO.getDispatchHouse())
                .apartment(orderDTO.getDispatchApartment())
                .build();
    }

    private Address getDeliveryAddress(OrderDTO orderDTO) {
        return Address.builder()
                .city(orderDTO.getDeliveryCity())
                .street(orderDTO.getDeliveryStreet())
                .house(orderDTO.getDeliveryHouse())
                .apartment(orderDTO.getDeliveryApartment())
                .build();
    }
//
//    // 2 - check Addresses presence in DB and create those if absent
//    private Optional<Address> getAddressFromDbByDispatchDetails(OrderDTO orderDTO)
//            throws DatabaseFetchException {
//
//        return addressRepository
//                .findAddressesByCityAndStreetAndHouseAndApartment(
//                        orderDTO.getDispatchCity(),
//                        orderDTO.getDispatchStreet(),
//                        orderDTO.getDispatchHouse(),
//                        orderDTO.getDispatchApartment());
//    }
//
//    private Optional<Address> getAddressFromDbByDeliveryDetails(OrderDTO orderDTO)
//            throws DatabaseFetchException {
//
//        return addressRepository
//                .findAddressesByCityAndStreetAndHouseAndApartment(
//                        orderDTO.getDeliveryCity(),
//                        orderDTO.getDeliveryStreet(),
//                        orderDTO.getDeliveryHouse(),
//                        orderDTO.getDeliveryApartment());
//    }
//
//    private Address defineDispatchAddress(OrderDTO orderDTO)
//            throws DatabaseFetchException {
//
//        return getAddressFromDbByDispatchDetails(orderDTO).orElse(
//                Address.builder()
//                        .city(orderDTO.getDispatchCity())
//                        .street(orderDTO.getDispatchStreet())
//                        .house(orderDTO.getDispatchHouse())
//                        .apartment(orderDTO.getDispatchApartment())
//                        .build());
//    }
//
//    private Address defineDeliveryAddress(OrderDTO orderDTO)
//            throws DatabaseFetchException {
//
//        return getAddressFromDbByDeliveryDetails(orderDTO).orElse(
//                Address.builder()
//                        .city(orderDTO.getDeliveryCity())
//                        .street(orderDTO.getDeliveryStreet())
//                        .house(orderDTO.getDeliveryHouse())
//                        .apartment(orderDTO.getDeliveryApartment())
//                        .build());
//    }
}
