package com.demo.car.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateCarQouteAction extends ActionSupport implements
		ServletContextAware, ModelDriven<CarQuoteEntity> {

	/**
	 *  statusMsg =  
	 */
	private String statusMsg;
	private ServletContext ctx;
	private CarQuoteEntity carQuoteM = new CarQuoteEntity();

	public String execute() {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CarQuoteDao carQuoteDao = new CarQuoteDaoImpl(sf);
		carQuoteM.setQuoteNo(generateQuoteNo());
		carQuoteM.setQuote(100000);
		CarQuoteEntity carQuoteM1 = carQuoteDao.saveCarQuote(carQuoteM);
		return SUCCESS;
	}

	public String generateQuoteNo() {

		int randomPIN = (int) (Math.random() * 9000) + 1000;
		String quoteNO = "QUO-" + randomPIN;
		return quoteNO;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	@Override
	public CarQuoteEntity getModel() {
		return carQuoteM;
	}

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}

}
