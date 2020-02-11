package com.training.projectlogistics.controller.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.training.projectlogistics.constants.BusinessInputConstants.*;

@Slf4j
public class WeightRangeConstraintValidator implements ConstraintValidator<WeightRange, BigDecimal> {
    @Override
    public void initialize(WeightRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(BigDecimal weight, ConstraintValidatorContext cvc) {
        if(weight == null) {
            return true;
        }

        BigDecimal inputWeight = weight
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal loweBoundWeight = new BigDecimal(WEIGHT_LIGHT_LOWER_BOUND)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal upperBoundWeight = new BigDecimal(WEIGHT_HEAVY_UPPER_BOUND)
                .setScale(2, RoundingMode.HALF_UP);

        return inputWeight.compareTo(loweBoundWeight) >= 0 &&
                inputWeight.compareTo(upperBoundWeight) <= 0;
    }
}
