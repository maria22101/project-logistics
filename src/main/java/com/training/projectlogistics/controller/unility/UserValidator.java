package com.training.projectlogistics.controller.unility;

import com.training.projectlogistics.model.User;
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
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // first checking if fields are "not null" and "no whitespace" - where relevant
        ValidationUtils.rejectIfEmpty(errors, "name", ERROR_COMMENT_NAME);
        ValidationUtils.rejectIfEmpty(errors, "surname", ERROR_COMMENT_SURNAME);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", ERROR_COMMENT_E_MAIL);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", ERROR_COMMENT_PASSWORD);

        // then process REGEX logic
        // conditional regex strings depending on the locale
        String regexStrName = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_NAME_UKR : REGEX_NAME_ENG);
        String regexStrSurname = (LocaleContextHolder.getLocale().toString().equals("ua")
                ? REGEX_SURNAME_UKR : REGEX_SURNAME_ENG);

        if ((StringUtils.hasText(user.getName()) &&
                !user.getName().matches(regexStrName))) {
            errors.rejectValue("name", ERROR_COMMENT_NAME);
        }
        if (StringUtils.hasText(user.getSurname()) &&
                !user.getSurname().matches(regexStrSurname)) {
            errors.rejectValue("surname", ERROR_COMMENT_SURNAME);
        }
        if (StringUtils.hasText(user.getEmail()) &&
                !user.getEmail().matches(REGEX_EMAIL)) {
            errors.rejectValue("email", ERROR_COMMENT_E_MAIL);
        }
        if (StringUtils.hasText(user.getPassword()) &&
                !user.getPassword().matches(REGEX_PASSWORD)) {
            errors.rejectValue("password", ERROR_COMMENT_PASSWORD);
        }
    }
}
