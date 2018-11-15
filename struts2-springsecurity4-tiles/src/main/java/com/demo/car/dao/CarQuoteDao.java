package com.demo.car.dao;

import java.util.List;

import com.demo.car.entity.CarQuoteEntity;

public interface CarQuoteDao {

	public CarQuoteEntity saveCarQuote(CarQuoteEntity carQuoteEntity);

	public CarQuoteEntity searchCarQuote(String quoteNo);

	public boolean checkCarQuoteNo(String quoteNo);

	public List<CarQuoteEntity> loadQuoteNo(String username);

	public List<CarQuoteEntity> loadQuoteNo();

}
