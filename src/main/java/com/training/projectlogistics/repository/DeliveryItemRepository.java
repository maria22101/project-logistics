package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.DeliveryItem;
import com.training.projectlogistics.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
}
