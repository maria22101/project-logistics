package com.training.projectlogistics.service;

import com.training.projectlogistics.model.DeliveryOrder;
import com.training.projectlogistics.model.DeliveryRoute;
import com.training.projectlogistics.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOrderService {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    public void createDeliveryOrder(String username) {

//        DeliveryOrder deliveryOrder = DeliveryOrder.builder()


    }

    private DeliveryRoute assignDeliveryRoute(String source, String destination) {
        return new DeliveryRoute();
    }
}
