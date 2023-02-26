package ntushares.rates.chronejob.proxy;

import feign.Param;
import feign.RequestLine;
import ntushares.rates.chronejob.entity.ApiRate;

public interface StockRateApiProxy {
	
	@RequestLine("GET /quote?symbol={symbol}&token=cfsch6pr01qgkckhcsa0cfsch6pr01qgkckhcsag")
	public ApiRate getStockRate(@Param("symbol") String symbol);

}
