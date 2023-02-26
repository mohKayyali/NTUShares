package ntu.stock.market.stockquote;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Share {
	
	@Id
	private String symbol;
	private String name;
	private double price;
	private LocalDateTime lastUpdatedDate;
	private int availableShares;
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public int getAvailableShares() {
		return availableShares;
	}
	public void setAvailableShares(int availableShares) {
		this.availableShares = availableShares;
	}
	
	
	

}
