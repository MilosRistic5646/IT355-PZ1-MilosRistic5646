package com.example.demo.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    private Car car;
    private Customer customer;
    private Employee employee;
    private Location location;
}
