package ntushares.rates.chronejob.proxy;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import feign.Param;
import feign.RequestLine;
import ntushares.rates.chronejob.entity.Share;

public interface StockQouteProxy {
	
	@RequestLine("GET")
	public List<Share> getShares();
	
	
	@RequestLine("GET /update/{symbol}/{rate}")
	public boolean updateShare(@Param("symbol") String symbol,@Param("rate") double rate);

}
