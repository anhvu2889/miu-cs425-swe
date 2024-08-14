package com.anhvu.exam.exception;

public class StationNotFoundException extends NotFoundException {
    public StationNotFoundException(Long id) {
        super("Station with id " + id + " not found");
    }
}
