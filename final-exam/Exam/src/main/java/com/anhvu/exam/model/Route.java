package com.anhvu.exam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "routes")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Station departureStation;

    private LocalTime departureTime;


    @ManyToOne()
    @JoinColumn(nullable = false)
    private Station arrivalStation;

    private LocalTime arrivalTime;
}
