package ntushares.rates.chronejob.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Response {
	
	private String base;
	private HashMap<String, Double> rates;
	private Date date;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public HashMap<String, Double> getRates() {
		return rates;
	}

	public void setRate(HashMap<String, Double> rate) {
		this.rates = rate;
	}

	public Date getUpdatDate() {
		return date;
	}

	public void setUpdatDate(Date date) {
		this.date = date;
	}
	

}
