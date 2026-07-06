package com.carvista.dto;

public class CarFilterRequest {

    private String brand;
    private Integer minPower;
    private Double minMileage;
    private Double maxPrice;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMinPower() {
        return minPower;
    }

    public void setMinPower(Integer minPower) {
        this.minPower = minPower;
    }

    public Double getMinMileage() {
        return minMileage;
    }

    public void setMinMileage(Double minMileage) {
        this.minMileage = minMileage;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}