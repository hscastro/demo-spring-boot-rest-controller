package com.hscastro.restcontroller.service;

import java.util.List;

import com.hscastro.restcontroller.model.Car;

public interface CarService {
 
    List<Car> getAllCars();    
 
    List<Car> getCarsWithPriceFilter(Double min, Double max);

    Car getById(Long id);

    Car update(Long id, Car carRequest);

    Car create(Car car);

    void delete(Long id);
}
