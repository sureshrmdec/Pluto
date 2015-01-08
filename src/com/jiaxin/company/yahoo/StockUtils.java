package com.jiaxin.company.yahoo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 
 * @author Jiaxin
 * @date May 14, 2014
 */
public class StockUtils {
	private LinkedList<Stock> queue;
	private TreeSet<Stock> set;
	private String stockName;
	
	public StockUtils(String stockName) {
		this.stockName = stockName;
		this.queue = new LinkedList<Stock>();
		this.set = new TreeSet<Stock>(stackComparator);
	}
	
	public double getCurrent() {
		if (queue.isEmpty()) {
			return 0;
		}
		
		return queue.getLast().price;
	}
	
	public double getMin() {
		if (set.first() == null) {
			return Double.MAX_VALUE;
		}
		
		return set.first().price;
	}
	
	public double getMax() {
		if (set.last() == null) {
			return Double.MIN_VALUE;
		}
		
		return set.last().price;
	}
	
	public void update(Stock newStock) {
		// Delete oldest stocks values		
		while (!queue.isEmpty() && isToDelete(newStock, queue.getFirst())) {			
			Stock deleted = queue.pollFirst();
			set.remove(deleted);
		}
		
		// Add new stock
		queue.addLast(newStock);
		set.add(newStock);		
	}
	

	private boolean isToDelete(Stock newStock, Stock head) {
		long duration = newStock.timestamp.getTime() - head.timestamp.getTime();
		if (duration / (1000 * 60 * 60 * 24) > 30) {
			return true;
		}
		 		
		return false;
	}

	private Comparator<Stock> stackComparator = new Comparator<Stock>() {

		@Override
		public int compare(Stock s1, Stock s2) {
			return (int) (s1.price - s2.price);
		}		
	};
	
	/*
	public class Stock {
		Timestamp timestamp;
		double price;
		
		public Stock(Timestamp timestamp, double price) {
			this.timestamp = timestamp;
			this.price = price;
		}
	}
	*/
}


