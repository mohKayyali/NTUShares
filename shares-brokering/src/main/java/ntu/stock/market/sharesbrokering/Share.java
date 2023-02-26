package ntu.stock.market.sharesbrokering;

import java.time.LocalDateTime;

public class Share {
	

	private String symbol;
	private String name;
	private double price;
	private LocalDateTime lastUpdatedDate;
	private int availableShares;

	private int userSharesCount;
	
	
	private double userSharesValue;
	
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
	public int getUserSharesCount() {
		return userSharesCount;
	}
	public void setUserSharesCount(int userSharesCount) {
		this.userSharesCount = userSharesCount;
	}
	public double getUserSharesValue() {
		return userSharesValue;
	}
	public void setUserSharesValue(double userSharesValue) {
		this.userSharesValue = userSharesValue;
	}
	
	
	
	
	

}
