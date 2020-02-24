package com.training.projectlogistics.controller.validation;

import com.training.projectlogistics.controller.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.training.projectlogistics.constants.TextConstants.*;
import static com.training.projectlogistics.constants.RegexContainer.*;

@Slf4j
@Component
public class OrderFormRegexValidator implements Validator {
    private final static String DISPATCH_STREET = "dispatchStreet";
    private final static String DISPATCH_HOUSE = "dispatchHouse";
    private final static String DISPATCH_APARTMENT ="dispatchApartment";

    private final static String DELIVERY_STREET = "deliveryStreet";
    private final static String DELIVERY_HOUSE = "deliveryHouse";
    private final static String DELIVERY_APARTMENT = "deliveryApartment";

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDTO dto = (OrderDTO) target;

        String regexStreet = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_STREET_UKR : REGEX_STREET_ENG);
        String regexHouse = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_HOUSE_UKR : REGEX_HOUSE_ENG);

        if ((StringUtils.hasText(dto.getDispatchStreet()) &&
                !dto.getDispatchStreet().matches(regexStreet))) {
            errors.rejectValue(DISPATCH_STREET, ERROR_COMMENT_DISPATCH_STREET);
        }
        if ((StringUtils.hasText(dto.getDispatchHouse()) &&
                !dto.getDispatchHouse().matches(regexHouse))) {
            errors.rejectValue(DISPATCH_HOUSE, ERROR_COMMENT_DISPATCH_HOUSE);
        }
        if ((StringUtils.hasText(dto.getDispatchApartment()) &&
                !dto.getDispatchApartment().matches(REGEX_APARTMENT))) {
            errors.rejectValue(DISPATCH_APARTMENT, ERROR_COMMENT_DISPATCH_APARTMENT);
        }
        if ((StringUtils.hasText(dto.getDeliveryStreet()) &&
                !dto.getDeliveryStreet().matches(regexStreet))) {
            errors.rejectValue(DELIVERY_STREET, ERROR_COMMENT_DELIVERY_STREET);
        }
        if ((StringUtils.hasText(dto.getDeliveryHouse()) &&
                !dto.getDeliveryHouse().matches(regexHouse))) {
            errors.rejectValue(DELIVERY_HOUSE, ERROR_COMMENT_DELIVERY_HOUSE);
        }
        if ((StringUtils.hasText(dto.getDeliveryApartment()) &&
                !dto.getDeliveryApartment().matches(REGEX_APARTMENT))) {
            errors.rejectValue(DELIVERY_APARTMENT, ERROR_COMMENT_DELIVERY_APARTMENT);
        }
    }
}
