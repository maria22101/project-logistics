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
            errors.rejectValue("dispatchStreet", ERROR_COMMENT_DISPATCH_STREET);
        }
        if ((StringUtils.hasText(dto.getDispatchHouse()) &&
                !dto.getDispatchHouse().matches(regexHouse))) {
            errors.rejectValue("dispatchHouse", ERROR_COMMENT_DISPATCH_HOUSE);
        }
        if ((StringUtils.hasText(dto.getDispatchApartment()) &&
                !dto.getDispatchApartment().matches(REGEX_APARTMENT))) {
            errors.rejectValue("dispatchApartment", ERROR_COMMENT_DISPATCH_APARTMENT);
        }
        if ((StringUtils.hasText(dto.getDeliveryStreet()) &&
                !dto.getDeliveryStreet().matches(regexStreet))) {
            errors.rejectValue("deliveryStreet", ERROR_COMMENT_DELIVERY_STREET);
        }
        if ((StringUtils.hasText(dto.getDeliveryHouse()) &&
                !dto.getDeliveryHouse().matches(regexHouse))) {
            errors.rejectValue("deliveryHouse", ERROR_COMMENT_DELIVERY_HOUSE);
        }
        if ((StringUtils.hasText(dto.getDeliveryApartment()) &&
                !dto.getDeliveryApartment().matches(REGEX_APARTMENT))) {
            errors.rejectValue("deliveryApartment", ERROR_COMMENT_DELIVERY_APARTMENT);
        }
    }
}
