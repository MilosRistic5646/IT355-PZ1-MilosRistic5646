package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Long id;
    private String city;
    private String address;
}
