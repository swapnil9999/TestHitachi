package com.demo.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quote_master")
public class CarQuoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quote_master_id")
	public long id;

	@Column(name = "quote_no")
	public String quoteNo;

	@Column(name = "car_make")
	public String carMake;

	@Column(name = "car_model")
	public String carModel;

	@Column(name = "yrs_of_manufacture")
	public String yrsOfManufacture;

	@Column(name = "doors")
	public String doors;

	@Column(name = "transmission")
	public String transmission;

	@Column(name = "fuel_type")
	public String fuelType;

	@Column(name = "engine_size")
	public String engineSize;

	@Column(name = "trim")
	public String trim;

	@Column(name = "quote")
	public long quote;

	@Column(name = "created_by")
	public String createdBy;
	
	@Column(name = "updated_by")
	public String updatedBy;


	public String getQuoteNo() {
		return quoteNo;
	}

	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getYrsOfManufacture() {
		return yrsOfManufacture;
	}

	public void setYrsOfManufacture(String yrsOfManufacture) {
		this.yrsOfManufacture = yrsOfManufacture;
	}

	public String getDoors() {
		return doors;
	}

	public void setDoors(String doors) {
		this.doors = doors;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuote() {
		return quote;
	}

	public void setQuote(long quote) {
		this.quote = quote;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
}