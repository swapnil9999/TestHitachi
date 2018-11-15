package com.demo.car.action;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditCarQuoteAction extends ActionSupport implements
		 ModelDriven<CarQuoteEntity> {


	private static final long serialVersionUID = 1L;
	private CarQuoteEntity carQuoteEntity = new CarQuoteEntity();
	private String username;

	@Override
	public String execute() throws Exception {
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl();
		CarQuoteEntity carQuote = carQuoteDao.searchCarQuote(carQuoteEntity.getQuoteNo());
		username = carQuote.getCreatedBy();
		carQuoteEntity.setQuoteNo(carQuote.getQuoteNo());
		carQuoteEntity.setCarMake(carQuote.getCarMake());
		carQuoteEntity.setCarModel(carQuote.getCarModel());
		carQuoteEntity.setYrsOfManufacture(carQuote.getYrsOfManufacture());
		carQuoteEntity.setDoors(carQuote.getDoors());
		carQuoteEntity.setTransmission(carQuote.getTransmission());
		carQuoteEntity.setFuelType(carQuote.getFuelType());
		carQuoteEntity.setEngineSize(carQuote.getEngineSize());
		carQuoteEntity.setTrim(carQuote.getTrim());
		carQuoteEntity.setId(carQuote.getId());
		carQuoteEntity.setQuote(carQuote.getQuote());
		carQuoteEntity.setCreatedBy(carQuote.getCreatedBy());
		return SUCCESS;
	}

	public String draftSave() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		carQuoteEntity.setUpdatedBy(userDetails.getUsername());
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl();
		carQuoteDao.saveCarQuote(carQuoteEntity);
		return SUCCESS;
	}

	@Override
	public CarQuoteEntity getModel() {
		return carQuoteEntity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
