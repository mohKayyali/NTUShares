package ntu.stock.market.exchangerate;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {

	CurrencyRepo repo;

	public Controller(CurrencyRepo repo) {
		this.repo = repo;
	}

	@GetMapping("/exchange-rate")
	public List<Currency> getCurrencies() {
		return repo.findAll();
	}

	@GetMapping("/exchange-rate/{currency}")
	public double getRate(@PathVariable String currency) {

		var cur = repo.findById(currency);

		if (!cur.isEmpty())
			return cur.get().getRate();

		return 0;

	}

	@GetMapping("/exchange-rate/currency/{symbol}/{rate}")
	public boolean updateRate(@PathVariable String symbol,@PathVariable double rate ) {

		Currency cur = repo.findById(symbol).get();

		cur.setRate(rate);
		repo.save(cur);
		
		System.out.println(cur.getSymbol());

		return true;

	}

}
