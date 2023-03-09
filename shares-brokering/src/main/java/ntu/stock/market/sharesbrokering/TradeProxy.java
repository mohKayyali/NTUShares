package ntu.stock.market.sharesbrokering;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="trade", url="${TRADE_URI:http://localhost}:6004")
public interface TradeProxy {
	
	@PostMapping("/trade/buy")
	public boolean buy(@RequestBody UserShare userShare);
	
	@PostMapping("/trade/sell")
	public boolean sell(@RequestBody UserShare userShare);

}
