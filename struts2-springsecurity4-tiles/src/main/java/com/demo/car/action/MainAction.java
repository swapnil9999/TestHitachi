package com.demo.car.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	public String username;
	public String password;
	private List<String> doors;
	private List<String> fuelType;
	private List<String> quoteNo;
	private List<String> carMake;
	private List<String> carModel;
	private List<String> yrsOfManufacture;
	private List<String> transmission;
	private List<String> trim;

	HttpServletRequest request = ServletActionContext.getRequest();

	public String execute() {
		this.setUsername(request.getUserPrincipal().getName());

		// setting values for No of Doors.
		doors = new ArrayList<String>();
		doors.add("1");
		doors.add("2");
		doors.add("3");
		doors.add("4");

		// setting values for Fuel Type.
		fuelType = new ArrayList<String>();
		fuelType.add("Petrol");
		fuelType.add("Diesel");
		fuelType.add("CNG Gas");

		// setting values for Car Make
		carMake = new ArrayList<String>();
		carMake.add("BMW");

		// setting values for Car Model
		carModel = new ArrayList<String>();
		carModel.add("A1");
		carModel.add("A2");
		carModel.add("A3");
		carModel.add("A4");
		carModel.add("A5");

		// setting values for Transmission
		transmission = new ArrayList<String>();
		transmission.add("Manual");
		transmission.add("Automatic");

		// setting values for year of manufacture
		yrsOfManufacture = new ArrayList<String>();
		yrsOfManufacture.add("2010");
		yrsOfManufacture.add("2011");
		yrsOfManufacture.add("2012");
		yrsOfManufacture.add("2013");
		yrsOfManufacture.add("2014");
		yrsOfManufacture.add("2015");
		yrsOfManufacture.add("2016");
		yrsOfManufacture.add("2017");

		// setting values for Trim
		trim = new ArrayList<String>();
		trim.add("A CABRIOLET");
		trim.add("A LINE CABRIOLET");
		trim.add("A SPORT CABRIOLET");

		return SUCCESS;
	}

	public String loadQuoteNo() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

		quoteNo = new ArrayList<String>();
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl();
		if (hasUserRole == true) {
			for (CarQuoteEntity carQuoteEntity : carQuoteDao.loadQuoteNo())
				quoteNo.add(carQuoteEntity.getQuoteNo());
		} else {
			for (CarQuoteEntity quoteEntity : carQuoteDao
					.loadQuoteNo(userDetails.getUsername()))
				quoteNo.add(quoteEntity.getQuoteNo());
		}
		return SUCCESS;

	}

	public List<String> getDoors() {
		return doors;
	}

	public void setDoors(List<String> doors) {
		this.doors = doors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getFuelType() {
		return fuelType;
	}

	public void setFuelType(List<String> fuelType) {
		this.fuelType = fuelType;
	}

	public List<String> getQuoteNo() {
		return quoteNo;
	}

	public void setQuoteNo(List<String> quoteNo) {
		this.quoteNo = quoteNo;
	}

	public List<String> getCarMake() {
		return carMake;
	}

	public void setCarMake(List<String> carMake) {
		this.carMake = carMake;
	}

	public List<String> getCarModel() {
		return carModel;
	}

	public void setCarModel(List<String> carModel) {
		this.carModel = carModel;
	}

	public List<String> getTransmission() {
		return transmission;
	}

	public void setTransmission(List<String> transmission) {
		this.transmission = transmission;
	}

	public List<String> getTrim() {
		return trim;
	}

	public void setTrim(List<String> trim) {
		this.trim = trim;
	}

	public List<String> getYrsOfManufacture() {
		return yrsOfManufacture;
	}

	public void setYrsOfManufacture(List<String> yrsOfManufacture) {
		this.yrsOfManufacture = yrsOfManufacture;
	}

}
