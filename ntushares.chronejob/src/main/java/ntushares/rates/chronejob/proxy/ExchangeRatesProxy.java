package ntushares.rates.chronejob.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Param;
import feign.RequestLine;

public interface ExchangeRatesProxy {
	
	
	@RequestLine("GET /symbol/{symbol}/rate/{rate}")
	public boolean updateRate(@Param("symbol") String symbol,@Param("rate") double rate );
	
	@RequestLine("GET {currency}")
	public double getRate(@Param("currency") String currency);
	

}
