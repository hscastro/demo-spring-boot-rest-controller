package com.hscastro.restcontroller.model;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
 
	private static final long serialVersionUID = -5184759406307547167L;
	
	private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;
    
    public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, String model, String brand, Integer horses, Double price) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.horses = horses;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getHorses() {
		return horses;
	}

	public void setHorses(Integer horses) {
		this.horses = horses;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(id, other.id) && Objects.equals(model, other.model);
	}
	
}
