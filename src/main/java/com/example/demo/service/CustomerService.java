package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerService {
    private final RentalService rentalService;

    private List<Customer> customers = new ArrayList<>();
    private long nextId = 1;

    public CustomerService(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(nextId++);
            customers.add(customer);
        } else {
            deleteById(customer.getId());
            customers.add(customer);
        }
    }

    public void deleteById(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            // prvo obriši povezane rentale
            rentalService.deleteByCustomer(customer);
            // pa onda obriši customera
            customers.removeIf(c -> c.getId().equals(id));
        }
    }
}
