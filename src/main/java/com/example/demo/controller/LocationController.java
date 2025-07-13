package com.example.demo.controller;

import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String listLocations(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "location/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("location", new Location());
        return "location/form";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("location", locationService.findById(id));
        return "location/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }
}
