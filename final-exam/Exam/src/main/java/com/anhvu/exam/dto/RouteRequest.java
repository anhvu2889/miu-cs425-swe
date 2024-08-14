package com.anhvu.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteRequest {
    private Long departureId;
    private Long arrivalId;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
}
