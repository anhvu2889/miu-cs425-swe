package com.anhvu.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "payment_info")
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cardNumber;
    @NotBlank
    private String issueName;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate expiryDate;
    @NotBlank
    private String securityCode;

    @ManyToOne()
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;
}
