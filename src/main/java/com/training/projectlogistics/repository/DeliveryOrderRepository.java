package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.DeliveryOrder;
import com.training.projectlogistics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
    Optional<DeliveryOrder> findById(Long id);
}