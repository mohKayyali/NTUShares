package ntu.stock.market.sharesbrokering;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="exchange-rate", url="${EXCHANGE_RATE_URI:http://localhost}:6011")
public interface ExchangeRateProxy {
	
	@GetMapping("/exchange-rate")
	public List<Currency> getCurrencies();
	
	@GetMapping("/exchange-rate/{currency}")
	public double getRate(@PathVariable String currency);
	
	@GetMapping("/exchange-rate/currency/{symbol}/{rate}")
	public boolean updateRate(@PathVariable String symbol,@PathVariable double rate );

}
