package com.training.projectlogistics.controller.validation;

import com.training.projectlogistics.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.training.projectlogistics.constants.ErrorConstants.*;
import static com.training.projectlogistics.constants.RegexContainer.*;
import static com.training.projectlogistics.constants.WebConstants.UA_LANGUAGE;

//TODO - substitute text with text constants
@Slf4j
@Component
public class RegistrationFormValidator implements Validator {
    private final static String NAME = "name";
    private final static String SURNAME = "surname";
    private final static String EMAIL = "email";
    private final static String PASSWORD = "password";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmpty(errors, NAME, ERROR_COMMENT_NAME);
        ValidationUtils.rejectIfEmpty(errors, SURNAME, ERROR_COMMENT_SURNAME);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, EMAIL, ERROR_COMMENT_E_MAIL);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, ERROR_COMMENT_PASSWORD);

        String regexStrName = (LocaleContextHolder.getLocale().toString().equals(UA_LANGUAGE)
                ? REGEX_NAME_UKR : REGEX_NAME_ENG);
        String regexStrSurname = (LocaleContextHolder.getLocale().toString().equals(UA_LANGUAGE)
                ? REGEX_SURNAME_UKR : REGEX_SURNAME_ENG);

        if ((StringUtils.hasText(user.getName()) &&
                !user.getName().matches(regexStrName))) {
            errors.rejectValue(NAME, ERROR_COMMENT_NAME);
        }
        if (StringUtils.hasText(user.getSurname()) &&
                !user.getSurname().matches(regexStrSurname)) {
            errors.rejectValue(SURNAME, ERROR_COMMENT_SURNAME);
        }
        if (StringUtils.hasText(user.getEmail()) &&
                !user.getEmail().matches(REGEX_EMAIL)) {
            errors.rejectValue(EMAIL, ERROR_COMMENT_E_MAIL);
        }
        if (StringUtils.hasText(user.getPassword()) &&
                !user.getPassword().matches(REGEX_PASSWORD)) {
            errors.rejectValue(PASSWORD, ERROR_COMMENT_PASSWORD);
        }
    }
}
