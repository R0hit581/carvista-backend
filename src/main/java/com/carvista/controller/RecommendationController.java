package com.carvista.controller;

import com.carvista.model.Car;
import com.carvista.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    private final CarRepository carRepository;

    public RecommendationController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> recommendCars(@RequestParam String brand,
                                   @RequestParam int minPower,
                                   @RequestParam double minMileage) {
        // Simple filter logic
        return carRepository.findAll().stream()
                .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                .filter(c -> c.getPower() >= minPower)
                .filter(c -> c.getMileage() >= minMileage)
                .toList();
    }
}
