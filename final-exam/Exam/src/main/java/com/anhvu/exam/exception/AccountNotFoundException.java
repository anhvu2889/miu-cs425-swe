package com.anhvu.exam.exception;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException(Long id) {
        super("Account id" + id + " not found");
    }
}
