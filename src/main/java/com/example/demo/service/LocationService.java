package com.example.demo.service;

import com.example.demo.model.Location;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LocationService {
    private List<Location> locations = new ArrayList<>();
    private long nextId = 1;

    public List<Location> findAll() {
        return locations;
    }

    public Location findById(Long id) {
        return locations.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Location location) {
        if (location.getId() == null) {
            location.setId(nextId++);
            locations.add(location);
        } else {
            deleteById(location.getId());
            locations.add(location);
        }
    }

    public void deleteById(Long id) {
        locations.removeIf(l -> l.getId().equals(id));
    }
}
