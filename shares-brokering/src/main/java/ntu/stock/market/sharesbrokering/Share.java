package ntu.stock.market.sharesbrokering;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Share {
	
	@Id
	private String symbol;
	private String name;
	private double price;
	
	@Transient 
	private int sharesCount;
	
	@Transient
	private double sharesValue;
	
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
	public int getSharesCount() {
		return sharesCount;
	}
	public void setSharesCount(int sharesCount) {
		this.sharesCount = sharesCount;
	}
	public double getSharesValue() {
		return sharesValue;
	}
	public void setSharesValue(double sharesValue) {
		this.sharesValue = sharesValue;
	}
	
	
	
	
	

}
