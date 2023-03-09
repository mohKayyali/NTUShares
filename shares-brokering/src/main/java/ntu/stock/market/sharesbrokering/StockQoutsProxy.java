package ntu.stock.market.sharesbrokering;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name="stock-quote", url="${STOCK_QOUTS_URI:http://localhost}:6002")
public interface StockQoutsProxy {
	
	@GetMapping("/stock-quote")
	public List<Share> getShares();
	
	@GetMapping("/stock-quote/update/{symbol}/{rate}")
	public boolean updateShare(@PathVariable String symbol,@PathVariable double rate);

}
