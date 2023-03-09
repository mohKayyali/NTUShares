package ntu.stock.market.currencyconversion;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="exchange-rate",url="${EXCHANGE_RATE_URI:http://localhost}:6011")
public interface CurrencyRateProxy {
	
	@GetMapping("/exchange-rate/{currency}")
	public double getRate(@PathVariable String currency);

}
