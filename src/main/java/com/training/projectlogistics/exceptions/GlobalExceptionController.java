package com.training.projectlogistics.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.training.projectlogistics.constants.ErrorConstants.EMAIL_EXISTS;
import static com.training.projectlogistics.constants.WebConstants.ERROR_MESSAGE;
import static com.training.projectlogistics.constants.WebConstants.GENERAL_ERROR_PAGE;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }

    @ExceptionHandler(DatabaseSaveException.class)
    public String handleDatabaseSaveException(DatabaseSaveException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    public String handleNotUniqueEmailException(Model model) {
        model.addAttribute(ERROR_MESSAGE, EMAIL_EXISTS);
        return GENERAL_ERROR_PAGE;
    }
}
