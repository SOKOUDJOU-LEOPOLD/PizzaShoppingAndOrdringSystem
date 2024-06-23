package com.example.pizzashop.utils.exception;

public class PaymentDeclineException extends RuntimeException {
    public PaymentDeclineException(){
        super("An error occured while processing the payment, payment declined!! Please try again");

    }

}

