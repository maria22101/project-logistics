package com.training.projectlogistics.model.validators;

import com.training.projectlogistics.model.enums.CargoType;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CargoTypeEnumValidator implements ConstraintValidator<CargoTypeSubset, CargoType> {
    private CargoType[] subset;

    @Override
    public void initialize(CargoTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(CargoType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
