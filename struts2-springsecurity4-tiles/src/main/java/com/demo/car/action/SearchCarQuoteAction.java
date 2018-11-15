package com.demo.car.action;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchCarQuoteAction extends ActionSupport implements
		 ModelDriven<CarQuoteEntity> {

	
	private static final long serialVersionUID = 1L;
	private CarQuoteEntity carQuoteEntity = new CarQuoteEntity();

	@Override
	public CarQuoteEntity getModel() {
		return carQuoteEntity;
	}

	@Override
	public String execute() throws Exception {
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl();
		CarQuoteEntity carQuoteEntity1 = carQuoteDao.searchCarQuote(carQuoteEntity.getQuoteNo());
		carQuoteEntity.setQuoteNo(carQuoteEntity1.getQuoteNo());
		carQuoteEntity.setCarMake(carQuoteEntity1.getCarMake());
		carQuoteEntity.setCarModel(carQuoteEntity1.getCarModel());
		carQuoteEntity.setId(carQuoteEntity1.getId());
		return SUCCESS;
	}

}
