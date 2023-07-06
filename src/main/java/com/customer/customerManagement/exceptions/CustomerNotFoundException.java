package com.customer.customerManagement.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUTD = 1;

    public CustomerNotFoundException(String message){
        super(message);
    }
}
