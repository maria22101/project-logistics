package com.training.projectlogistics.model.validators;

import com.training.projectlogistics.model.enums.WeightCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, WeightCategory> {
    private WeightCategory[] subset;

    @Override
    public void initialize(CustomerTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(WeightCategory value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
