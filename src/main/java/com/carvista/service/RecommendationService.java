package com.carvista.service;

import com.carvista.dto.CarFilterRequest;
import com.carvista.model.Car;
import com.carvista.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final CarRepository carRepository;

    public RecommendationService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> searchCars(CarFilterRequest request) {
        return carRepository.searchCars(request);
    }
}