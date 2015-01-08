package com.jiaxin.company.yahoo;

import java.sql.Timestamp;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		StockUtils stockUtil = new StockUtils("WB");
		
		Stock stock = new Stock(new Timestamp(new Date().getTime()), 3.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
				
		stock = new Stock(new Timestamp(new Date().getTime()), 10.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
		
		stock = new Stock(new Timestamp(new Date().getTime()), 5.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
		
		stock = new Stock(new Timestamp(new Date().getTime()), 8.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
		
		stock = new Stock(new Timestamp(new Date().getTime()), 2.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
		
		stock = new Stock(new Timestamp(new Date().getTime()), 9.0);
		stockUtil.update(stock);
		System.out.println(stockUtil.getCurrent() + " " + stockUtil.getMax() + " " + stockUtil.getMin());
	}
		
	
	
	
}
