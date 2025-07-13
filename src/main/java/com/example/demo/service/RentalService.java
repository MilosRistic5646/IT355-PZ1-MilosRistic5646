package com.example.demo.service;

import com.example.demo.model.Rental;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RentalService {
    private List<Rental> rentals = new ArrayList<>();
    private long nextId = 1;

    public List<Rental> findAll() {
        return rentals;
    }

    public Rental findById(Long id) {
        return rentals.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Rental rental) {
        if (rental.getId() == null) {
            rental.setId(nextId++);
            rentals.add(rental);
        } else {
            deleteById(rental.getId());
            rentals.add(rental);
        }
    }

    public void deleteById(Long id) {
        rentals.removeIf(r -> r.getId().equals(id));
    }
}
