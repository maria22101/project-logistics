package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Weight_input;
import com.training.projectlogistics.model.enums.WeightCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface Weight_inputRepository extends JpaRepository<Weight_input, Long> {
    Optional<Weight_input> getByWeightCategory(WeightCategory weightCategory);
    Optional<Weight_input> findByRangeFromLessThanAndRangeToGreaterThan(BigDecimal weight1, BigDecimal weight2);
}
