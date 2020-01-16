package com.training.projectlogistics.service;

import com.training.projectlogistics.model.DeliveryOrder;
import com.training.projectlogistics.model.DeliveryRoute;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.Weight_input;
import com.training.projectlogistics.model.dto.DeliveryOrderDTO;
import com.training.projectlogistics.model.enums.Cargo;
import com.training.projectlogistics.model.enums.Delivery_order_status;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class DeliveryOrderService {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeliveryRouteRepository deliveryRouteRepository;

    @Autowired
    Cargo_inputRepository cargo_inputRepository;

    @Autowired
    Weight_inputRepository weight_inputRepository;

    public void createDeliveryOrder(String username,
                                    DeliveryOrderDTO deliveryOrderDTO) {

        User user = userRepository.findByUsername(username).get();

        DeliveryOrder deliveryOrder = DeliveryOrder.builder()
                .deliveryDate(deliveryOrderDTO.getDeliveryDate())
                .weight(deliveryOrderDTO.getWeight())
                .cargo(deliveryOrderDTO.getCargo())
                .sum(getSum(deliveryOrderDTO))
                .delivery_route(getDeliveryRoute(deliveryOrderDTO))
                .user(user)
//                .invoice(null)
                .delivery_order_status(Delivery_order_status.OPEN)
                .build();

        deliveryOrderRepository.save(deliveryOrder);
    }

    private DeliveryRoute getDeliveryRoute(DeliveryOrderDTO deliveryOrderDTO) {
        return deliveryRouteRepository
                .findBySourceAndDestination(deliveryOrderDTO.getSource(), deliveryOrderDTO.getDestination())
                .get();
    }

    private BigDecimal getSum(DeliveryOrderDTO deliveryOrderDTO) {
        BigDecimal basicRate = deliveryRouteRepository
                .findBySourceAndDestination(deliveryOrderDTO.getSource(), deliveryOrderDTO.getDestination())
                .get()
                .getBasicRate();
        BigDecimal cargoCoefficient = cargo_inputRepository
                .getCargo_inputByCargo(deliveryOrderDTO.getCargo())
                .get()
                .getCargoCoefficient();
        BigDecimal weightCoefficient = getWeight_input(deliveryOrderDTO).getWeightCoefficient();

        return basicRate
                .multiply(cargoCoefficient)
                .multiply(weightCoefficient)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private Weight_input getWeight_input(DeliveryOrderDTO deliveryOrderDTO) {
        return weight_inputRepository
                .findByRangeFromLessThanAndRangeToGreaterThan(deliveryOrderDTO.getWeight(), deliveryOrderDTO.getWeight())
                .get();
    }
}
