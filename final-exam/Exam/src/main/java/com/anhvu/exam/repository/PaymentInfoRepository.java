package com.anhvu.exam.repository;

import com.anhvu.exam.model.Passenger;
import com.anhvu.exam.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    List<PaymentInfo> findByPassenger(Passenger passenger);
}
