package com.example.pizzashop.utils.exception;

public class IncorrectCredentials extends RuntimeException {
    public IncorrectCredentials() {
        super("Wrong credentials!! Please try again");
    }
}
