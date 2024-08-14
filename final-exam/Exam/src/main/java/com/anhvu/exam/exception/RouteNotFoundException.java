package com.anhvu.exam.exception;

public class RouteNotFoundException extends NotFoundException {
    public RouteNotFoundException(Long id) {
        super("Route with id " + id + " not found");
    }
}
