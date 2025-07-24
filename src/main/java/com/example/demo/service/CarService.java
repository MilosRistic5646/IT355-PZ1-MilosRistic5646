package com.example.demo.service;

import com.example.demo.model.Car;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CarService {
    private final RentalService rentalService;

    private List<Car> cars = new ArrayList<>();
    private long nextId = 1;

    public CarService(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public List<Car> findAll() {
        return cars;
    }

    public Car findById(Long id) {
        return cars.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Car car) {
        if (car.getId() == null) {
            car.setId(nextId++);
            cars.add(car);
        } else {
            deleteById(car.getId());
            cars.add(car);
        }
    }

    public void deleteById(Long id) {
        Car car = findById(id);
        if (car != null) {
            rentalService.deleteByCar(car);
            cars.removeIf(c -> c.getId().equals(id));
        }
    }
}
