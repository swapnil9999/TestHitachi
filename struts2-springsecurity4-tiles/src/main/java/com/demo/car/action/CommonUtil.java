package com.demo.car.action;

public class CommonUtil {

   public static String generateQuoteNo() {
	   int randomPIN = (int) (Math.random() * 9000) + 1000;
		String quoteNO = "QUO-" + randomPIN;
		return quoteNO;
	}
}
