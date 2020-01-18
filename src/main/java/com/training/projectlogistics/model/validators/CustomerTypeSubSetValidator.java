package com.training.projectlogistics.model.validators;

import com.training.projectlogistics.model.enums.Cargo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, Cargo> {
    private Cargo[] subset;

    @Override
    public void initialize(CustomerTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Cargo value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
