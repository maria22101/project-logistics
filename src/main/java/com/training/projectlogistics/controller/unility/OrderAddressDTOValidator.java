package com.training.projectlogistics.controller.unility;

import com.training.projectlogistics.model.dto.OrderAddressDTO;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.training.projectlogistics.controller.TextConstants.*;
import static com.training.projectlogistics.controller.unility.RegexContainer.*;

//TODO - substitute text with text constants
@Component
public class OrderAddressDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return OrderAddressDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderAddressDTO dto = (OrderAddressDTO) target;

        ValidationUtils.rejectIfEmpty(errors, "source", ERROR_COMMENT_SOURCE);
        ValidationUtils.rejectIfEmpty(errors, "destination", ERROR_COMMENT_DESTINATION);
        ValidationUtils.rejectIfEmpty(errors, "street", ERROR_COMMENT_STREET);
        ValidationUtils.rejectIfEmpty(errors, "house", ERROR_COMMENT_HOUSE);
        ValidationUtils.rejectIfEmpty(errors, "apartment", ERROR_COMMENT_APARTMENT);
        ValidationUtils.rejectIfEmpty(errors, "deliveryDate", ERROR_COMMENT_DELIVERY_DATE);
        ValidationUtils.rejectIfEmpty(errors, "weight", ERROR_COMMENT_WEIGHT);
        ValidationUtils.rejectIfEmpty(errors, "cargoType", ERROR_COMMENT_CARGO_TYPE);

        String regexSource = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_SOURCE_UKR : REGEX_SOURCE_ENG);
        String regexDestination = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_DESTINATION_UKR : REGEX_DESTINATION_ENG);
        String regexStreet = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_STREET_UKR : REGEX_STREET_ENG);
        String regexHouse = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_HOUSE_UKR : REGEX_HOUSE_ENG);
        String regexCargo = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_CARGO_TYPE_UKR : REGEX_CARGO_TYPE_ENG);

        if ((StringUtils.hasText(dto.getSource()) &&
                !dto.getSource().matches(regexSource))) {
            errors.rejectValue("source", ERROR_COMMENT_SOURCE);
        }
        if ((StringUtils.hasText(dto.getDestination()) &&
                !dto.getDestination().matches(regexDestination))) {
            errors.rejectValue("destination", ERROR_COMMENT_DESTINATION);
        }
        if ((StringUtils.hasText(dto.getStreet()) &&
                !dto.getStreet().matches(regexStreet))) {
            errors.rejectValue("street", ERROR_COMMENT_STREET);
        }
        if ((StringUtils.hasText(dto.getHouse()) &&
                !dto.getHouse().matches(regexHouse))) {
            errors.rejectValue("house", ERROR_COMMENT_HOUSE);
        }
        if ((StringUtils.hasText(dto.getApartment()) &&
                !dto.getApartment().matches(REGEX_APARTMENT))) {
            errors.rejectValue("apartment", ERROR_COMMENT_APARTMENT);
        }
        if ((StringUtils.hasText(dto.getDeliveryDate().toString()) &&
                !dto.getDeliveryDate().toString().matches(REGEX_DELIVERY_DATE))) {
            errors.rejectValue("deliveryDate", ERROR_COMMENT_DELIVERY_DATE);
        }
        if ((StringUtils.hasText(dto.getWeight().toString()) &&
                !dto.getWeight().toString().matches(REGEX_WEIGHT))) {
            errors.rejectValue("weight", ERROR_COMMENT_WEIGHT);
        }
        if ((StringUtils.hasText(dto.getCargoType().toString()) &&
                !dto.getCargoType().toString().matches(regexCargo))) {
            errors.rejectValue("cargoType", ERROR_COMMENT_CARGO_TYPE);
        }

        // add all form fields
    }
}
