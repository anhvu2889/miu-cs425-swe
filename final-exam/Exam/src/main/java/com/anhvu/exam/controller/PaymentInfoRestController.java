package com.anhvu.exam.controller;

import com.anhvu.exam.dto.PaymentInfoRequest;
import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.exception.PaymentInfoNotFoundException;
import com.anhvu.exam.model.Passenger;
import com.anhvu.exam.model.PaymentInfo;
import com.anhvu.exam.service.PassengerService;
import com.anhvu.exam.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paymentInfo", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentInfoRestController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<PaymentInfo>> findAll() {
        return new ResponseEntity<>(paymentInfoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentInfo> save(@RequestBody PaymentInfoRequest paymentInfoRequest) throws PassengerNotFoundException {
        Passenger passenger = passengerService.findById(paymentInfoRequest.getPassengerId());

        PaymentInfo paymentInfo = PaymentInfo.build(null,
                paymentInfoRequest.getCardNumber(),
                paymentInfoRequest.getIssueName(),
                paymentInfoRequest.getExpiryDate(),
                paymentInfoRequest.getSecurityCode(),
                passenger);
        return new ResponseEntity<>(paymentInfoService.save(paymentInfo), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PaymentInfo> findById(@PathVariable Long id) throws PaymentInfoNotFoundException {
        return new ResponseEntity<>(paymentInfoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws PaymentInfoNotFoundException {
        paymentInfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/byPassenger/{userId}")
    public ResponseEntity<List<PaymentInfo>> findByPassengerId(@PathVariable Long userId) throws PassengerNotFoundException {
        return new ResponseEntity<>(paymentInfoService.findByPassengerId(userId), HttpStatus.OK);
    }
}
