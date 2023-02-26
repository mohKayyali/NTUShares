package ntushares.rates.chronejob.proxy;

import org.springframework.web.bind.annotation.PathVariable;

import feign.Param;
import feign.RequestLine;

public interface CurrencyConversionProxy {
	
	
	@RequestLine("GET /currency/{currency}/amount/{amount}")
	public double convert(@Param("currency") String currency,@Param("amount") double amount);

}
