package com.anhvu.exam.exception;

public class PaymentInfoNotFoundException extends NotFoundException {

    public PaymentInfoNotFoundException(Long id) {
        super("Payment id " + id + " not found");
    }
    public PaymentInfoNotFoundException() {
        super("Payment is not found");
    }
}
