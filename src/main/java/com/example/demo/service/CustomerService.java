package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private long nextId = 1;

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
        customers.removeIf(c -> c.getId().equals(id));
    }
}
