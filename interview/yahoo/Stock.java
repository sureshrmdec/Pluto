package interview.yahoo;

import java.sql.Timestamp;

public class Stock {
	Timestamp timestamp;
	double price;
	
	public Stock(Timestamp timestamp, double price) {
		this.timestamp = timestamp;
		this.price = price;
	}
}