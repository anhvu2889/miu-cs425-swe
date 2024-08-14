package com.anhvu.exam.exception;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(Integer id) {
        super("Customer id " + id + " not found");
    }
}
