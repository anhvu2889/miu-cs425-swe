package com.anhvu.exam.service;

import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.exception.PaymentInfoNotFoundException;
import com.anhvu.exam.model.Passenger;
import com.anhvu.exam.model.PaymentInfo;
import com.anhvu.exam.repository.PassengerRepository;
import com.anhvu.exam.repository.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PassengerRepository passengerRepository;


    @Override
    public PaymentInfo save(PaymentInfo paymentInfo) {

        return paymentInfoRepository.save(paymentInfo);
    }

    @Override
    public PaymentInfo update(PaymentInfo paymentInfo) {
        return paymentInfoRepository.save(paymentInfo);
    }

    @Override
    public PaymentInfo findById(Long id) throws PaymentInfoNotFoundException {
        return paymentInfoRepository.findById(id).orElseThrow(() -> new PaymentInfoNotFoundException(id));
    }

    @Override
    public List<PaymentInfo> findAll() {
        return paymentInfoRepository.findAll();
    }

    @Override
    public List<PaymentInfo> findByPassengerId(Long passengerId) throws PassengerNotFoundException {
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);
        if (passengerOptional.isPresent()) {
            return paymentInfoRepository.findByPassenger(passengerOptional.get());
        }
        throw new PassengerNotFoundException(passengerId);

    }

    @Override
    public void deleteById(Long id) {
        paymentInfoRepository.deleteById(id);
    }
}
