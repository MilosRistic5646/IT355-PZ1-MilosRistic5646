package com.example.demo.controller;

import com.example.demo.model.Rental;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    @Autowired private RentalService rentalService;
    @Autowired private CarService carService;
    @Autowired private CustomerService customerService;
    @Autowired private EmployeeService employeeService;
    @Autowired private LocationService locationService;

    @GetMapping
    public String listRentals(Model model) {
        model.addAttribute("rentals", rentalService.findAll());
        return "rental/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("rental", new Rental());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "rental/form";
    }

    @PostMapping("/save")
    public String saveRental(@ModelAttribute Rental rental) {
        rentalService.save(rental);
        return "redirect:/rentals";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("rental", rentalService.findById(id));
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "rental/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRental(@PathVariable Long id) {
        rentalService.deleteById(id);
        return "redirect:/rentals";
    }
}
