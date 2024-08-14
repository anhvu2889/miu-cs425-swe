package com.anhvu.exam.service;

import com.anhvu.exam.dto.PaymentInfoRequest;
import com.anhvu.exam.exception.PassengerNotFoundException;
import com.anhvu.exam.exception.PaymentInfoNotFoundException;
import com.anhvu.exam.model.PaymentInfo;

import java.util.List;

public interface PaymentInfoService {
    PaymentInfo save(PaymentInfo paymentInfo);

    PaymentInfo update(PaymentInfo paymentInfo);

    PaymentInfo findById(Long id) throws PaymentInfoNotFoundException;

    List<PaymentInfo> findAll();

    List<PaymentInfo> findByPassengerId(Long userId) throws PassengerNotFoundException;

    void deleteById(Long id);
}
