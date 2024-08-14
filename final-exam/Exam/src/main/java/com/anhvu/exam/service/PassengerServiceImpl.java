package com.anhvu.exam.service;

import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.model.Passenger;
import com.anhvu.exam.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger findById(Long id) throws PassengerNotFoundException {
        return passengerRepository.findById(id).orElseThrow(() -> new PassengerNotFoundException(id));
    }

    @Override
    public Passenger add(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void delete(Long id) throws PassengerNotFoundException {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(() -> new PassengerNotFoundException(id));
        passengerRepository.delete(passenger);
    }
}
