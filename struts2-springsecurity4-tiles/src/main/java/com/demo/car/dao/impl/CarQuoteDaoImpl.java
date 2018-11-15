package com.demo.car.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.core.userdetails.User;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.entity.CarQuoteEntity;

public class CarQuoteDaoImpl implements CarQuoteDao {

	private SessionFactory sf;

	public CarQuoteDaoImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public CarQuoteEntity saveCarQuote(CarQuoteEntity carQuote_M) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(carQuote_M);
		tx.commit();
		session.close();
		return carQuote_M;
	}

	@Override
	public CarQuoteEntity searchCarQuote(String quoteNo) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from CarQuote_M where quote_no=:quoteNo");
		query.setString("quoteNo", quoteNo);
		CarQuoteEntity carQuote_M = (CarQuoteEntity) query.uniqueResult();
		return carQuote_M;
	}

	@Override
	public boolean checkCarQuoteNo(String quoteNo) {
		boolean flag = false;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from CarQuote_M where quote_no=:quoteNo");
		query.setString("quoteNo", quoteNo);
		CarQuoteEntity carQuote_M = (CarQuoteEntity) query.uniqueResult();
		if (carQuote_M == null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<CarQuoteEntity> loadQuoteNo(String username) {
		List<CarQuoteEntity> carQuote_Ms;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from CarQuote_M where created_by=:username");
		query.setString("username", username);

		carQuote_Ms = (List<CarQuoteEntity>) query.list();
		return carQuote_Ms;
	}

	@Override
	public List<CarQuoteEntity> loadQuoteNo() {
		List<CarQuoteEntity> carQuote_Ms;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from CarQuote_M ");

		carQuote_Ms = (List<CarQuoteEntity>) query.list();
		return carQuote_Ms;
	}
}
