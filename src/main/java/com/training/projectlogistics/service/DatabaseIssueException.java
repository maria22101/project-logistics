package com.training.projectlogistics.service;

public class DatabaseIssueException extends Exception {
    String message;

    public DatabaseIssueException(String message) {
        this.message = message;
    }
}
