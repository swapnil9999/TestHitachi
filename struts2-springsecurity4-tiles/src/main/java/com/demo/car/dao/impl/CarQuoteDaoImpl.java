package com.demo.car.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.car.dao.CarQuoteDao;
import com.demo.car.entity.CarQuoteEntity;
import com.demo.car.hbm.listener.HibernateUtility;

public class CarQuoteDaoImpl implements CarQuoteDao {

	private SessionFactory sf;

	public CarQuoteDaoImpl() {
	}

	@Override
	public CarQuoteEntity saveCarQuote(CarQuoteEntity carQuoteEntity) {
		sf=HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(carQuoteEntity);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return carQuoteEntity;
	}

	@Override
	public CarQuoteEntity searchCarQuote(String quoteNo) {
		sf=HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CarQuoteEntity carQuoteEntity = null;
		try {

			Query query = session
					.createQuery("from CarQuoteEntity where quote_no=:quoteNo");
			query.setString("quoteNo", quoteNo);
			carQuoteEntity = (CarQuoteEntity) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return carQuoteEntity;
	}

	@Override
	public boolean checkCarQuoteNo(String quoteNo) {
		sf=HibernateUtility.getSessionFactory();
		boolean flag = false;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session
					.createQuery("from CarQuoteEntity where quote_no=:quoteNo");
			query.setString("quoteNo", quoteNo);
			CarQuoteEntity carQuoteEntity = (CarQuoteEntity) query.uniqueResult();
			if (carQuoteEntity == null) {
				flag = true;
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return flag;
	}

	@Override
	public List<CarQuoteEntity> loadQuoteNo(String username) {
		List<CarQuoteEntity> carQuoteEntities = null;
		sf=HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session
					.createQuery("from CarQuoteEntity where created_by=:username");
			query.setString("username", username);

			carQuoteEntities = (List<CarQuoteEntity>) query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return carQuoteEntities;
	}

	@Override
	public List<CarQuoteEntity> loadQuoteNo() {
		List<CarQuoteEntity> carQuoteEntities = null;
		sf=HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Query query = session.createQuery("from CarQuoteEntity ");

			carQuoteEntities = (List<CarQuoteEntity>) query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return carQuoteEntities;
	}
}
