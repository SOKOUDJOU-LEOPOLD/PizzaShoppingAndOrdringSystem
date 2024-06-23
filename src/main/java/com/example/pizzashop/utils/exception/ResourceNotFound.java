package com.example.pizzashop.utils.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String resourceName){
        super(String.format("resource %s not found!!", resourceName));

    }

}