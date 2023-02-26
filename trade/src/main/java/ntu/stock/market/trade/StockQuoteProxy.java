package ntu.stock.market.trade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="stock-quote",url="localhost:6002")
public interface StockQuoteProxy {
	
	@PutMapping("/stock-quote/change-availability/operation/{operation}/count/{count}/symbol/{symbol}")
	public boolean updateShare(@PathVariable String operation,@PathVariable int count,@PathVariable String symbol);

}
