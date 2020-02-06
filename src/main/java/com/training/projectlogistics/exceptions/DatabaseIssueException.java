package com.training.projectlogistics.exceptions;

public class DatabaseIssueException extends Exception {
    String message;

    public DatabaseIssueException(String message) {
        this.message = message;
    }
}
