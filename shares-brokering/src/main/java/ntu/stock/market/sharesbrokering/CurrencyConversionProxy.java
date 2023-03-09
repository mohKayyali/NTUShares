package ntu.stock.market.sharesbrokering;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-conversion", url="${CURRENCY_CONVERSION_URI:http://localhost}:6012")
public interface CurrencyConversionProxy {
	
	@GetMapping("/currency-conversion/currency/{currency}/amount/{amount}")
	public double convert(@PathVariable String currency,@PathVariable double amount);

}
