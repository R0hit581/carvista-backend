package com.carvista.repository;

import com.carvista.dto.CarFilterRequest;
import com.carvista.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByPowerGreaterThan(int power);
    List<Car> findByMileageGreaterThan(double mileage);

    @Query("""
    SELECT c
    FROM Car c
    WHERE (:#{#filter.brand} IS NULL OR LOWER(c.brand) = LOWER(:#{#filter.brand}))
    AND (:#{#filter.minPower} IS NULL OR c.power >= :#{#filter.minPower})
    AND (:#{#filter.minMileage} IS NULL OR c.mileage >= :#{#filter.minMileage})
    AND (:#{#filter.maxPrice} IS NULL OR c.price <= :#{#filter.maxPrice})
    """)
    List<Car> searchCars(@Param("filter") CarFilterRequest filter);
}
