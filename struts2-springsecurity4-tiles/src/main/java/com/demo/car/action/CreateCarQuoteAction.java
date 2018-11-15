package com.demo.car.action;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateCarQuoteAction extends ActionSupport implements ModelDriven<CarQuoteEntity> {

	
	private static final long serialVersionUID = 1L;
	private String statusMsg;
	private CarQuoteEntity carQuote = new CarQuoteEntity();

	public String execute() {
		try {
			CarQuoteDao carQuoteDao = new CarQuoteDaoImpl();
			carQuote.setQuoteNo(CommonUtil.generateQuoteNo());
			carQuote.setQuote(100000);
			carQuoteDao.saveCarQuote(carQuote);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	@Override
	public CarQuoteEntity getModel() {
		return carQuote;
	}

}
