package com.training.projectlogistics.service.order;

import com.training.projectlogistics.model.Route;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.training.projectlogistics.constants.BusinessInputConstants.*;

@Service
public class OrderSumCalculationService {

    public BigDecimal calculateSum(BigDecimal weight, Route route) {
        return route.getBasicRate()
                .multiply(getWeightRateCoefficient(weight))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getWeightRateCoefficient(BigDecimal weight) {

        BigDecimal weightRateCoefficient;

        if (weight.compareTo(new BigDecimal(WEIGHT_LIGHT_UPPER_BOUND)
                .setScale(2, RoundingMode.HALF_UP)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_LIGHT_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);

        } else if (weight.compareTo(new BigDecimal(WEIGHT_MEDIUM_UPPER_BOUND)
                .setScale(2, RoundingMode.HALF_UP)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_MEDIUM_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);

        } else {
            weightRateCoefficient = new BigDecimal(WEIGHT_HEAVY_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        return weightRateCoefficient;
    }
}
