package com.example.pizzashop.utils.exception;

public class InternalSystemError extends RuntimeException {
    public InternalSystemError() {
        super("Internal System Error occurred!!");
    }

}