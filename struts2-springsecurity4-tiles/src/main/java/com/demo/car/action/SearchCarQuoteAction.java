package com.demo.car.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchCarQuoteAction extends ActionSupport implements
		ServletContextAware, ModelDriven<CarQuoteEntity> {

	private CarQuoteEntity carQuote_M = new CarQuoteEntity();

	@Override
	public CarQuoteEntity getModel() {
		return carQuote_M;
	}

	private ServletContext ctx;

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}

	@Override
	public String execute() throws Exception {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl(sf);
		CarQuoteEntity carQuote_M1 = carQuoteDao.searchCarQuote(carQuote_M.getQuoteNo());
		carQuote_M.setQuoteNo(carQuote_M1.getQuoteNo());
		carQuote_M.setCarMake(carQuote_M1.getCarMake());
		carQuote_M.setCarModel(carQuote_M1.getCarModel());
		carQuote_M.setId(carQuote_M1.getId());
		return SUCCESS;
	}

}
