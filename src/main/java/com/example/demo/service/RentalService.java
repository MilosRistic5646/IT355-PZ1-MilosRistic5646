package com.example.demo.service;

import com.example.demo.model.*;
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

    public void deleteByCustomer(Customer customer) {
        rentals.removeIf(r -> r.getCustomer() != null && r.getCustomer().equals(customer));
    }

    public void deleteByCar(Car car) {
        rentals.removeIf(r -> r.getCar() != null && r.getCar().equals(car));
    }

    public void deleteByEmployee(Employee employee) {
        rentals.removeIf(r -> r.getEmployee() != null && r.getEmployee().equals(employee));
    }

    public void deleteByLocation(Location location) {
        rentals.removeIf(r -> r.getLocation() != null && r.getLocation().equals(location));
    }
}
