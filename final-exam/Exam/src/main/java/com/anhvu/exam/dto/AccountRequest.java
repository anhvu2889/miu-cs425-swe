package com.anhvu.exam.dto;

import com.anhvu.exam.model.ActiveStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class AccountRequest {
    private String accountNumber;
    private LocalDate dateOpened;
    private ActiveStatus status = ActiveStatus.ACTIVE;
    private Double balance;
}
