package com.carvista.repository;

import com.carvista.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByPowerGreaterThan(int power);
    List<Car> findByMileageGreaterThan(double mileage);
}
