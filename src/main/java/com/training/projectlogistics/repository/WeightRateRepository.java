package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.WeightRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface WeightRateRepository extends JpaRepository<WeightRate, Long> {
    Optional<WeightRate> findByWeightFromLessThanAndWeightToGreaterThan(BigDecimal weight1, BigDecimal weight2);
    Optional<WeightRate> findByWeightFromIsLessThanEqualAndWeightToGreaterThanEqual
            (BigDecimal weight1, BigDecimal weight2);
}
