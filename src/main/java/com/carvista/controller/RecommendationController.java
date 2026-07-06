package com.carvista.controller;

import com.carvista.dto.CarFilterRequest;
import com.carvista.model.Car;
import com.carvista.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
@CrossOrigin(origins = "http://localhost:4200")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/search")
    public List<Car> searchCars(@RequestBody CarFilterRequest request) {
        return recommendationService.searchCars(request);
    }
}