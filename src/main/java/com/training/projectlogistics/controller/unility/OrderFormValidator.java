package com.training.projectlogistics.controller.unility;

import com.training.projectlogistics.model.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.training.projectlogistics.constants.TextConstants.*;
import static com.training.projectlogistics.constants.RegexContainer.*;

//TODO - substitute text with text constants

@Slf4j
@Component
public class OrderFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return OrderDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDTO dto = (OrderDTO) target;

        log.info("inside OrderFormValidator");

        ValidationUtils.rejectIfEmpty(errors, "dispatchCity", ERROR_COMMENT_DISPATCH_CITY);
        ValidationUtils.rejectIfEmpty(errors, "dispatchStreet", ERROR_COMMENT_DISPATCH_STREET);
        ValidationUtils.rejectIfEmpty(errors, "dispatchHouse", ERROR_COMMENT_DISPATCH_HOUSE);
        ValidationUtils.rejectIfEmpty(errors, "deliveryCity", ERROR_COMMENT_DELIVERY_CITY);
        ValidationUtils.rejectIfEmpty(errors, "deliveryStreet", ERROR_COMMENT_DELIVERY_STREET);
        ValidationUtils.rejectIfEmpty(errors, "deliveryHouse", ERROR_COMMENT_DELIVERY_HOUSE);
        ValidationUtils.rejectIfEmpty(errors, "deliverydate", ERROR_COMMENT_DELIVERY_DATE);
        ValidationUtils.rejectIfEmpty(errors, "weight", ERROR_COMMENT_WEIGHT);
        ValidationUtils.rejectIfEmpty(errors, "cargotype", ERROR_COMMENT_CARGO_TYPE);

//        String regexCity = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_CITY_UKR : REGEX_CITY_ENG);
//        String regexStreet = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_STREET_UKR : REGEX_STREET_ENG);
//        String regexHouse = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_HOUSE_UKR : REGEX_HOUSE_ENG);
//        String regexCargo = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_CARGO_TYPE_UKR : REGEX_CARGO_TYPE_ENG);
////
//        if ((StringUtils.hasText(dto.getDispatchcity()) &&
//                !dto.getDispatchcity().matches(regexCity))) {
//            errors.rejectValue("dispatchcity", ERROR_COMMENT_CITY);
//        }
//        if ((StringUtils.hasText(dto.getDispatchstreet()) &&
//                !dto.getDispatchcity().matches(regexStreet))) {
//            errors.rejectValue("dispatchstreet", ERROR_COMMENT_STREET);
//        }
//
//        log.info("errors content: " + errors.toString());
//
//        if ((StringUtils.hasText(dto.getDispatchHouse()) &&
//                !dto.getDispatchHouse().matches(regexHouse))) {
//            errors.rejectValue("dispatchHouse", ERROR_COMMENT_HOUSE);
//        }
//        if ((StringUtils.hasText(dto.getDispatchApartment()) &&
//                !dto.getDispatchApartment().matches(REGEX_APARTMENT))) {
//            errors.rejectValue("dispatchApartment", ERROR_COMMENT_APARTMENT);
//        }
//        if ((StringUtils.hasText(dto.getDeliveryCity()) &&
//                !dto.getDeliveryCity().matches(regexCity))) {
//            errors.rejectValue("deliveryCity", ERROR_COMMENT_CITY);
//        }
//        if ((StringUtils.hasText(dto.getDeliveryStreet()) &&
//                !dto.getDeliveryStreet().matches(regexStreet))) {
//            errors.rejectValue("deliveryStreet", ERROR_COMMENT_STREET);
//        }
//        if ((StringUtils.hasText(dto.getDeliveryHouse()) &&
//                !dto.getDeliveryHouse().matches(regexHouse))) {
//            errors.rejectValue("deliveryHouse", ERROR_COMMENT_HOUSE);
//        }
//        if ((StringUtils.hasText(dto.getDeliveryApartment()) &&
//                !dto.getDeliveryApartment().matches(REGEX_APARTMENT))) {
//            errors.rejectValue("deliveryApartment", ERROR_COMMENT_APARTMENT);
//        }
////        if ((StringUtils.hasText(dto.getDeliveryDate().toString()) &&
////                !dto.getDeliveryDate().toString().matches(REGEX_DELIVERY_DATE))) {
////            errors.rejectValue("deliveryDate", ERROR_COMMENT_DELIVERY_DATE);
////        }
////        if ((StringUtils.hasText(dto.getWeight().toString()) &&
////                !dto.getWeight().toString().matches(REGEX_WEIGHT))) {
////            errors.rejectValue("weight", ERROR_COMMENT_WEIGHT);
////        }
//        if ((StringUtils.hasText(dto.getCargoType().toString()) &&
//                !dto.getCargoType().toString().matches(regexCargo))) {
//            errors.rejectValue("cargoType", ERROR_COMMENT_CARGO_TYPE);
//        }

        log.info("Order creation form validation completed. Errors content: " + errors.toString());
    }
}
