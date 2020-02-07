package com.training.projectlogistics.controller.unility;

import com.training.projectlogistics.model.dto.OrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.training.projectlogistics.constants.TextConstants.*;

//TODO - substitute text with text constants
@Component
public class OrderFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return OrderDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDTO dto = (OrderDTO) target;

        ValidationUtils.rejectIfEmpty(errors, "dispatchCity", ERROR_COMMENT_CITY);
//        ValidationUtils.rejectIfEmpty(errors, "dispatchStreet", ERROR_COMMENT_STREET);
//        ValidationUtils.rejectIfEmpty(errors, "dispatchHouse", ERROR_COMMENT_HOUSE);
//        ValidationUtils.rejectIfEmpty(errors, "dispatchApartment", ERROR_COMMENT_APARTMENT);
//        ValidationUtils.rejectIfEmpty(errors, "deliveryCity", ERROR_COMMENT_CITY);
//        ValidationUtils.rejectIfEmpty(errors, "deliveryStreet", ERROR_COMMENT_STREET);
//        ValidationUtils.rejectIfEmpty(errors, "deliveryHouse", ERROR_COMMENT_HOUSE);
//        ValidationUtils.rejectIfEmpty(errors, "deliveryApartment", ERROR_COMMENT_APARTMENT);
//        ValidationUtils.rejectIfEmpty(errors, "deliveryDate", ERROR_COMMENT_DELIVERY_DATE);
//        ValidationUtils.rejectIfEmpty(errors, "weight", ERROR_COMMENT_WEIGHT);
//        ValidationUtils.rejectIfEmpty(errors, "cargoType", ERROR_COMMENT_CARGO_TYPE);

//        String regexCity = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_CITY_UKR : REGEX_CITY_ENG);
//        String regexStreet = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_STREET_UKR : REGEX_STREET_ENG);
//        String regexHouse = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_HOUSE_UKR : REGEX_HOUSE_ENG);
//        String regexCargo = (LocaleContextHolder.getLocale().toString().equals("ua")
//                ? REGEX_CARGO_TYPE_UKR : REGEX_CARGO_TYPE_ENG);
//
//        if ((StringUtils.hasText(dto.getDispatchCity()) &&
//                !dto.getDispatchCity().matches(regexCity))) {
//            errors.rejectValue("dispatchCity", ERROR_COMMENT_CITY);
//        }
//        if ((StringUtils.hasText(dto.getDispatchStreet()) &&
//                !dto.getDispatchCity().matches(regexStreet))) {
//            errors.rejectValue("dispatchStreet", ERROR_COMMENT_STREET);
//        }
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
//        if ((StringUtils.hasText(dto.getDeliveryDate().toString()) &&
//                !dto.getDeliveryDate().toString().matches(REGEX_DELIVERY_DATE))) {
//            errors.rejectValue("deliveryDate", ERROR_COMMENT_DELIVERY_DATE);
//        }
//        if ((StringUtils.hasText(dto.getWeight().toString()) &&
//                !dto.getWeight().toString().matches(REGEX_WEIGHT))) {
//            errors.rejectValue("weight", ERROR_COMMENT_WEIGHT);
//        }
//        if ((StringUtils.hasText(dto.getCargoType().toString()) &&
//                !dto.getCargoType().toString().matches(regexCargo))) {
//            errors.rejectValue("cargoType", ERROR_COMMENT_CARGO_TYPE);
//        }
    }
}
