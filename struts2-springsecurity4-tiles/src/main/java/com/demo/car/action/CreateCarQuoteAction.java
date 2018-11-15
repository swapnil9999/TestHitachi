package com.demo.car.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.dao.impl.CarQuoteDaoImpl;
import com.demo.car.entity.CarQuoteEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateCarQuoteAction extends ActionSupport
		implements
			ServletContextAware,
			ModelDriven<CarQuoteEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * statusMsg =
	 */
	private String statusMsg;
	private ServletContext ctx;
	private CarQuoteEntity carQuote = new CarQuoteEntity();

	public String execute() {
		try {
			SessionFactory sf = (SessionFactory) ctx
					.getAttribute("SessionFactory");
			CarQuoteDao carQuoteDao = new CarQuoteDaoImpl(sf);
			carQuote.setQuoteNo(generateQuoteNo());
			carQuote.setQuote(100000);
			carQuoteDao.saveCarQuote(carQuote);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	/**
	 * @return
	 */
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
		return carQuote;
	}

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}

}
