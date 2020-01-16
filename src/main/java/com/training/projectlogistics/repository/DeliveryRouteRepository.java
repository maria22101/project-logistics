package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.DeliveryOrder;
import com.training.projectlogistics.model.DeliveryRoute;
import com.training.projectlogistics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DeliveryRouteRepository extends JpaRepository<DeliveryRoute, Long> {
    Optional<DeliveryRoute> findById(Long id);
    Optional<DeliveryRoute> findBySourceAndDestination(String source, String destination);
}
