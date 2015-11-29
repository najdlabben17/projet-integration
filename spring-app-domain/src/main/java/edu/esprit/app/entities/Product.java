package edu.esprit.app.entities;

import java.io.Serializable;

import javassist.SerialVersionUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product implements Serializable {

	/** {@link SerialVersionUID} */
	private static final long serialVersionUID = 4537480759471168201L;

	@NotEmpty
	@Id
	private String serialNumber;
	@NotEmpty
	@Size(min = 3, max = 20)
	private String designation;
	@DecimalMin(value = "100")
	private Double price;
	@DecimalMin(value = "1")
	private Long quantity;

	public Product() {
	}

	public Product(String serialNumber, String designation, Double price,
			Long quantity) {
		super();
		this.serialNumber = serialNumber;
		this.designation = designation;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
