package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private String make;
    private String model;
    private int year;
    private boolean available;
}
