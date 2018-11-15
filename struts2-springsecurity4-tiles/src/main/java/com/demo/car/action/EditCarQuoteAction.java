package com.demo.car.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditCarQuoteAction extends ActionSupport implements
		ServletContextAware, ModelDriven<CarQuoteEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CarQuoteEntity carQuote_M = new CarQuoteEntity();
	private String username;
	private ServletContext ctx;

	@Override
	public String execute() throws Exception {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl(sf);
		
		carQuote_M= carQuoteDao.searchCarQuote(carQuote_M
				.getQuoteNo());
		CarQuoteEntity carQuote_M1 = carQuoteDao.searchCarQuote(carQuote_M
				.getQuoteNo());
		username = carQuote_M1.getCreatedBy();
		carQuote_M.setQuoteNo(carQuote_M1.getQuoteNo());
		carQuote_M.setCarMake(carQuote_M1.getCarMake());
		carQuote_M.setCarModel(carQuote_M1.getCarModel());
		carQuote_M.setYrsOfManufacture(carQuote_M1.getYrsOfManufacture());
		carQuote_M.setDoors(carQuote_M1.getDoors());
		carQuote_M.setTransmission(carQuote_M1.getTransmission());
		carQuote_M.setFuelType(carQuote_M1.getFuelType());
		carQuote_M.setEngineSize(carQuote_M1.getEngineSize());
		carQuote_M.setTrim(carQuote_M1.getTrim());
		carQuote_M.setId(carQuote_M1.getId());
		carQuote_M.setQuote(carQuote_M1.getQuote());
		carQuote_M.setCreatedBy(carQuote_M1.getCreatedBy());
		return SUCCESS;
	}

	public String draftSave() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		carQuote_M.setUpdatedBy(userDetails.getUsername());
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl(sf);
		CarQuoteEntity carQuote_M1 = carQuoteDao.saveCarQuote(carQuote_M);
		return SUCCESS;
	}

	@Override
	public CarQuoteEntity getModel() {
		return carQuote_M;
	}

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
