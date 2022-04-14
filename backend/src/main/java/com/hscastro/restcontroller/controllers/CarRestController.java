package com.hscastro.restcontroller.controllers;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.restcontroller.model.Car;
import com.hscastro.restcontroller.service.CarServiceImpl;

@RestController
@RequestMapping(value = "/")
public class CarRestController {
	
	@Autowired
	private CarServiceImpl carServiceImpl;

	@GetMapping(value = "cars", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getAll(){
		List<Car> listCars = this.carServiceImpl.getAllCars();
		return ResponseEntity.ok(listCars);
	}

	@GetMapping(params = {"minPrice", "maxPrice"}, value = "cars",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getAllByPrice(
			@RequestParam @Positive(message = "O parâmetro minPrice deve ser maior que zero") Double minPrice,
			@RequestParam @Positive(message = "parâmetro maxPrice deve ser maior que zero") Double maxPrice){
		
		List<Car> listCars = this.carServiceImpl.getCarsWithPriceFilter(minPrice, maxPrice);
		return ResponseEntity.ok(listCars);
	}

	@GetMapping(value = "cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
		Car car = this.carServiceImpl.getById(id);
		return ResponseEntity.ok(car);
	}	
	
	@PostMapping
	public ResponseEntity<Car> createCar(@RequestBody Car car){
		return ResponseEntity.ok(this.carServiceImpl.create(car));
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, Long id){
		return ResponseEntity.ok(this.carServiceImpl.update(id, car));
	}	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable("id") Long id){
		this.carServiceImpl.delete(id);
	}
	
}
