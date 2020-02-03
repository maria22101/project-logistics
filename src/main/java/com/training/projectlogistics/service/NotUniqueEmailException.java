package com.training.projectlogistics.service;

public class NotUniqueEmailException extends Exception {
    private String email;

    public NotUniqueEmailException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
