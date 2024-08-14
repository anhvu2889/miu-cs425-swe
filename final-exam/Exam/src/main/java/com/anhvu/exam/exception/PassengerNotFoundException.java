package com.anhvu.exam.exception;

public class PassengerNotFoundException extends NotFoundException {
    public PassengerNotFoundException() {
        super("Passenger Not Found");
    }

    public PassengerNotFoundException(Long id) {
        super("Passenger id " + id + " Not Found");
    }
}
