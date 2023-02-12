package ntu.stock.market.exchangerate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {
	
	@Id
	private String symbol;
	private double rate;
	private String name;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
