package com.payment.service.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (String message){
        super(message);
    }
}
