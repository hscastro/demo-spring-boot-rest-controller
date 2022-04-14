package com.hscastro.restcontroller.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hscastro.restcontroller.model.Car;

@Service
public class CarServiceImpl implements CarService {
	
    private List<Car> cars = new ArrayList<>(
            Arrays.asList(
                new Car(1L,"HB20", "Hyunday", 100, 18000d),
                new Car(2L, "Argo", "Fiat", 120, 22000d),
                new Car(3L, "Golf", "VW", 90, 17000d)
    )       );

	@Override
	public List<Car> getAllCars() {
		return this.cars;
	}

	@Override
	public List<Car> getCarsWithPriceFilter(Double min, Double max) {
		return this.cars.stream()
				.filter(car -> car.getPrice() >= min && car.getPrice() <= max)
				.toList();
	}

	@Override
	public Car getById(Long id) {
		return this.cars.stream()
				.filter(car -> car.getId().equals(id))
				.findAny()
				.orElseThrow();
	}

	@Override
	public Car update(Long id, Car carRequest) {
		Car carUpdate = this.getById(id);
		carUpdate.setBrand(carRequest.getBrand());
		carUpdate.setHorses(carRequest.getHorses());
		carUpdate.setId(carRequest.getId());
		carUpdate.setModel(carRequest.getModel());
		carUpdate.setPrice(carRequest.getPrice());
		return carUpdate;
	}

	@Override
	public Car create(Car car) {
		Long idCreate = this.cars.stream()
				.mapToLong(car_ -> Long.valueOf(car_.getId()))
				.max().orElse(0L) + 1L;
		car.setId(idCreate);
		this.cars.add(car);
		
		return this.getById(car.getId());
	}

	@Override
	public void delete(Long id) {
		boolean successfulDeletion = 
				this.cars.removeIf(car -> car.getId().equals(id));
		
		if(!successfulDeletion) {
			throw new NoSuchElementException();
		}	
	}

}
