package ntu.stock.market.sharesbrokering;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;




@FeignClient(name="stock-quote", url="localhost:6002")
public interface StockQoutsProxy {
	
	@GetMapping("/stock-quote")
	public List<Share> getShares();

}
