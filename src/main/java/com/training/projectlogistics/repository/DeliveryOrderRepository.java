package com.training.projectlogistics.repository;

import com.training.projectlogistics.entity.Delivery_order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderRepository extends JpaRepository<Delivery_order, Long> {
}