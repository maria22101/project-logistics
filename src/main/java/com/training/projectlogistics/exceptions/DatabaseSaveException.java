package com.training.projectlogistics.exceptions;

import static com.training.projectlogistics.constants.ErrorConstants.DATABASE_SAVING_ISSUE;

public class DatabaseSaveException extends Exception {
    private static final String message = DATABASE_SAVING_ISSUE;

    public DatabaseSaveException() {
    }

    @Override
    public String toString() {
        return message;
    }
}
