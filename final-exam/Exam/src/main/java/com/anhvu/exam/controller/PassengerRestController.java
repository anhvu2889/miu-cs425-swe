package com.anhvu.exam.controller;

import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.model.Passenger;
import com.anhvu.exam.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/passengers"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerRestController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping(value = {""})
    public ResponseEntity<List<Passenger>> getAllPassenger() {
        return new ResponseEntity<>(passengerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) throws PassengerNotFoundException {
        return new ResponseEntity<>(passengerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(passengerService.add(passenger), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) throws PassengerNotFoundException {
        passengerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
