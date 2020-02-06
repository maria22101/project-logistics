package com.training.projectlogistics.controller;

import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;

public interface TextConstants {
    String EMAIL_EXISTS = "registration.emailexist.error.message";
    String DATABASE_ISSUE = "database.action.failed";

    //registration form validation
    String ERROR_COMMENT_NAME = "input.error.name";
    String ERROR_COMMENT_SURNAME = "input.error.surname";
    String ERROR_COMMENT_E_MAIL = "input.error.email";
    String ERROR_COMMENT_PASSWORD = "input.error.password";

    //order creation form validation
    String ERROR_COMMENT_CITY = "input.error.source";
    String ERROR_COMMENT_STREET = "input.error.street";
    String ERROR_COMMENT_HOUSE = "input.error.house";
    String ERROR_COMMENT_APARTMENT = "input.error.apartment";
    String ERROR_COMMENT_DELIVERY_DATE = "input.error.delivery.date";
    String ERROR_COMMENT_WEIGHT = "input.error.weight";
    String ERROR_COMMENT_CARGO_TYPE = "input.error.cargotype";

    String WEIGHT_LIGHT_LOWER_BOUND = "weight.light.lower.bound.value";
    String WEIGHT_LIGHT_UPPER_BOUND = "weight.light.upper.bound.value";
    String WEIGHT_MEDIUM_LOWER_BOUND = "weight.medium.lower.bound.value";
    String WEIGHT_MEDIUM_UPPER_BOUND = "weight.medium.upper.bound.value";
    String WEIGHT_HEAVY_LOWER_BOUND = "weight.heavy.lower.bound.value";
    String WEIGHT_HEAVY_UPPER_BOUND = "weight.heavy.upper.bound.value";

    String WEIGHT_LIGHT_COEFFICIENT = "weight.coeff.light";
    String WEIGHT_MEDIUM_COEFFICIENT = "weight.coeff.medium";
    String WEIGHT_HEAVY_COEFFICIENT = "weight.coeff.heavy";
}
