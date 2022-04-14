package com.hscastro.restcontroller.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Car implements Serializable {
 
	private static final long serialVersionUID = -5184759406307547167L;
	
	private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;
    
    //@NotNull annotation means that this field must not be null and it must be included in the request body.
    //A anotação @NotNull significa que este campo não deve ser nulo e deve ser incluído no corpo da solicitação.
    
    //@NotEmpty: annotation means that this String field cannot be empty.
    //anotação significa que este campo String não pode estar vazio.
    
    //@Positive means that this field must have a value greater than zero
    //significa que este campo deve ter um valor maior que zero
    
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

	@NotNull(message = "O modelo não pode ser nulo")
	@NotEmpty(message = "O modelo deve ter valor")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@NotNull(message = "Brand não pode ser nulo")
	@NotEmpty(message = "Brand deve ter valor")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@NotNull(message = "Os cavalos não devem ser nulos")
	@Positive
	public Integer getHorses() {
		return horses;
	}

	public void setHorses(Integer horses) {
		this.horses = horses;
	}

	@NotNull(message = "O preço não pode ser nulo")
	@Positive
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
