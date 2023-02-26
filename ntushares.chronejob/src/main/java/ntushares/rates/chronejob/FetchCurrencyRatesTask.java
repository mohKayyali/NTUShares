package ntushares.rates.chronejob;

import java.util.List;
import java.util.TimerTask;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import ntushares.rates.chronejob.entity.ApiRate;
import ntushares.rates.chronejob.entity.Share;
import ntushares.rates.chronejob.proxy.ExchangeRatesProxy;
import ntushares.rates.chronejob.proxy.RatesResponseProxy;
import ntushares.rates.chronejob.proxy.StockQouteProxy;
import ntushares.rates.chronejob.proxy.StockRateApiProxy;

class FetchCurrencyRatesTask extends TimerTask {

	private static final String API_PATH = "https://api.currencybeacon.com/v1/latest?api_key=dd6a9907061d3d8a6dcabdcfe7f5f03d&base=gbp&symbols=EUR,GBP,INR,JOD,JPY,SAR,UED,USD";
	private static final String API_PATHCurrencyRates = "http://localhost:6011/exchange-rate";
	private static final String API_PATH_STOCK_QUOTE = "http://localhost:6002/stock-quote";
	private static final String API_PATH_STOCK_API = "https://finnhub.io/api/v1";

	@Override
	public void run() {

		fetchCurrencyRates();

		fetchStocksRates();

	}

	private void fetchStocksRates() {

		try {

			StockQouteProxy stockQouteProxy = Feign.builder().decoder(new GsonDecoder()).target(StockQouteProxy.class,
					API_PATH_STOCK_QUOTE);

			List<Share> shares = stockQouteProxy.getShares();

			StockRateApiProxy stockRateApiProxy = Feign.builder().decoder(new GsonDecoder())
					.target(StockRateApiProxy.class, API_PATH_STOCK_API);

			ExchangeRatesProxy exchangeRatesProxy = Feign.builder().encoder(new GsonEncoder())
					.decoder(new GsonDecoder()).target(ExchangeRatesProxy.class, API_PATHCurrencyRates);

			for (Share share : shares) {

				ApiRate response = stockRateApiProxy.getStockRate(share.getSymbol());
				double usdRate = exchangeRatesProxy.getRate("USD");

				double value = Math.round((response.getC() / usdRate) * 100.0) / 100.0;

				stockQouteProxy.updateShare(share.getSymbol(), value);

				System.out.println(share.getSymbol() + "  GBP  " + value + "  USD  " + response.getC());

			}
		} catch (Exception ex) {

			System.out.println(ex.getMessage());

		}

	}

	private void fetchCurrencyRates() {

		try {
			RatesResponseProxy ratesResponseProxy = Feign.builder().decoder(new GsonDecoder())
					.target(RatesResponseProxy.class, API_PATH);

			ratesResponseProxy.getRates().getResponse().getRates().forEach((key, value) -> {
				System.out.println("Key=" + key + ", Value=" + value);

				ExchangeRatesProxy exchangeRatesProxy = Feign.builder().encoder(new GsonEncoder())
						.decoder(new GsonDecoder()).target(ExchangeRatesProxy.class, API_PATHCurrencyRates);

				exchangeRatesProxy.updateRate(key, value);

			});

		} catch (Exception ex) {

			System.out.println(ex.getMessage());

		}
	}

}
