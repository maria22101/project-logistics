package com.training.projectlogistics.constants;

import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;

public interface TextConstants {
    String EMAIL_EXISTS = "registration.emailexist.error.message";
    String DATABASE_FETCH_ISSUE = "database.fetch.issue";
    String DATABASE_SAVING_ISSUE = "database.saving.issue";

    //registration form validation
    String ERROR_COMMENT_NAME = "input.error.name";
    String ERROR_COMMENT_SURNAME = "input.error.surname";
    String ERROR_COMMENT_E_MAIL = "input.error.email";
    String ERROR_COMMENT_PASSWORD = "input.error.password";

    //order creation form validation
    String ERROR_COMMENT_DISPATCH_CITY = "input.error.dispatch.city";
    String ERROR_COMMENT_DELIVERY_CITY = "input.error.delivery.city";
    String ERROR_COMMENT_DISPATCH_STREET = "input.error.dispatch.street";
    String ERROR_COMMENT_DELIVERY_STREET = "input.error.delivery.street";
    String ERROR_COMMENT_DISPATCH_HOUSE = "input.error.dispatch.house";
    String ERROR_COMMENT_DELIVERY_HOUSE = "input.error.delivery.house";
    String ERROR_COMMENT_DISPATCH_APARTMENT = "input.error.dispatch.apartment";
    String ERROR_COMMENT_DELIVERY_APARTMENT = "input.error.delivery.apartment";
    String ERROR_COMMENT_DELIVERY_DATE = "input.error.delivery.date";
    String ERROR_COMMENT_WEIGHT = "input.error.weight";
    String ERROR_COMMENT_CARGO_TYPE = "input.error.cargotype";

    //enums localization
    String CARGO_REGULAR = "CargoType.REGULAR";
    String CARGO_FRAGILE = "CargoType.FRAGILE";
}
