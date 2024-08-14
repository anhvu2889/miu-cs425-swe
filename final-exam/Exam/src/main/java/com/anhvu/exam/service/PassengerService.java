package com.anhvu.exam.service;

import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> findAll();
    Passenger findById(Long id) throws PassengerNotFoundException;
    Passenger add(Passenger passenger);
    Passenger update(Passenger passenger);
    void delete(Long id) throws PassengerNotFoundException;
}
