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

	
	private static final long serialVersionUID = 1L;
	private CarQuoteEntity carQuoteEntity = new CarQuoteEntity();

	@Override
	public CarQuoteEntity getModel() {
		return carQuoteEntity;
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
		CarQuoteEntity carQuoteEntity1 = carQuoteDao.searchCarQuote(carQuoteEntity.getQuoteNo());
		carQuoteEntity.setQuoteNo(carQuoteEntity1.getQuoteNo());
		carQuoteEntity.setCarMake(carQuoteEntity1.getCarMake());
		carQuoteEntity.setCarModel(carQuoteEntity1.getCarModel());
		carQuoteEntity.setId(carQuoteEntity1.getId());
		return SUCCESS;
	}

}
