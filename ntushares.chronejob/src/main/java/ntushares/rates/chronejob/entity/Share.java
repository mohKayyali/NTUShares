package ntushares.rates.chronejob.entity;

import java.time.LocalDateTime;

public class Share {
	
	private String symbol;
	
	private double price;
	
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
