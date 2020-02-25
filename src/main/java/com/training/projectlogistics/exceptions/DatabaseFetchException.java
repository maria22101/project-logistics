package com.training.projectlogistics.exceptions;

import static com.training.projectlogistics.constants.ErrorConstants.DATABASE_FETCH_ISSUE;

public class DatabaseFetchException extends Exception {
    private static final String message = DATABASE_FETCH_ISSUE;

    public DatabaseFetchException() {
    }

    @Override
    public String toString() {
        return message;
    }
}
