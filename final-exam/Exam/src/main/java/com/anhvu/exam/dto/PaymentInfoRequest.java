package com.anhvu.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoRequest {
    private String cardNumber;
    private String issueName;
    private LocalDate expiryDate;
    private String securityCode;
    private Long passengerId;
}
