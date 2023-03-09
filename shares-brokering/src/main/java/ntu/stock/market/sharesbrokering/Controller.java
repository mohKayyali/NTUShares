package ntu.stock.market.sharesbrokering;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

	@Autowired
	private StockQoutsProxy stockQoutsProxy;

	@Autowired
	private ExchangeRateProxy exchangeRateProxy;

	@Autowired
	CurrencyConversionProxy currencyConversioproxy;

	@Autowired
	UserSharesProxy userSharesProxy;
	
	@Autowired
	TradeProxy tradeProxy;
	
	@GetMapping("/shares-brokering/stock-quote")
	public  List<Share> getSharesRates() {

		try {
			return stockQoutsProxy.getShares();
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}

		return null;
	}

	@GetMapping("/shares-brokering/currency/{currency}")
	public List<Share> getShares(@PathVariable String currency) {

		try {
			List<Share> shares = stockQoutsProxy.getShares();

			List<UserShare> userShares = userSharesProxy.getUserShares(1);

			for (Share share : shares) {

				share.setPrice(currencyConversioproxy.convert(currency, share.getPrice()));

				UserShare uShare = userShares.stream()
						.filter(userShare -> userShare.getShareSymbol().equals(share.getSymbol())).findFirst()
						.orElse(null);

				if (uShare != null) {
					share.setUserSharesCount(uShare.getShareCount());
					double value = Math.round((share.getPrice() * uShare.getShareCount() * 100.0)) / 100.0;
					share.setUserSharesValue(value);
				}

			}

			return shares;
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}
		
		return null;
	}

	@GetMapping("/shares-brokering/currency-rates")
	public List<Currency> getCurrencies() {

		try {
			return exchangeRateProxy.getCurrencies();
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}

		return null;
	}

	@GetMapping("/shares-brokering/currency-rates/{currency}")
	public double getRate(@PathVariable String currency) {

		try {
			return exchangeRateProxy.getRate(currency);
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}

		return -1;
	}

	@GetMapping("/shares-brokering/currency-rates/symbol/{symbol}/rate/{rate}")
	public boolean updateRate(@PathVariable String symbol, @PathVariable double rate) {

		try {
			return exchangeRateProxy.updateRate(symbol, rate);
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}

		return false;
	}
	
	@GetMapping("/shares-brokering/currency-conversion/currency/{currency}/amount/{amount}")
	public double convert(@PathVariable String currency,@PathVariable double amount) {
		
		try {
			return currencyConversioproxy.convert(currency, amount);
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}
		
		return -1;
	}
	
	@PostMapping("/shares-brokering/trade/{operatoin}")
	public  boolean buy(@RequestBody UserShare share,@PathVariable String operatoin) {
		
		try {
			if(operatoin.toLowerCase().equals("buy"))
			return tradeProxy.buy(share);
			else if(operatoin.toLowerCase().equals("sell"))
				return tradeProxy.sell(share);
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}
		
		return false;
	}
	
	
	
	@GetMapping("/shares-brokering/stock-quote/update/{symbol}/{rate}")
	public boolean updateShare(@PathVariable String symbol,@PathVariable double rate) {
		
		try {
			return stockQoutsProxy.updateShare(symbol,rate);
		} catch (Exception e) {

			Logger.getLogger("Logging").log(Level.SEVERE, e.getMessage());
		}
		
		return false;
		
	}

}
