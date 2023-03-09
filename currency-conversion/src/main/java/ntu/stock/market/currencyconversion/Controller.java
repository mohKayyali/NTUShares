package ntu.stock.market.currencyconversion;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
	
	@Autowired
	private CurrencyRateProxy proxy;
	
	@GetMapping("/currency-conversion/currency/{currency}/amount/{amount}")
	public double convert(@PathVariable String currency,@PathVariable  double amount) {
		
		try {
		double rate=proxy.getRate(currency);
		
		 double value=rate*amount;
		 
		 return Math.round(value * 100.0) / 100.0;
		}
		catch(Exception e) {
			
			Logger.getLogger("Logging").log(Level.SEVERE,e.getMessage());
		}
		return 0;
		
	}
	

}
