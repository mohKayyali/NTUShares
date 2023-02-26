package ntushares.rates.chronejob.proxy;



import feign.RequestLine;
import ntushares.rates.chronejob.entity.CurrencyRatesResponse;

public interface RatesResponseProxy {
	
	@RequestLine("GET")
	CurrencyRatesResponse getRates();

}
