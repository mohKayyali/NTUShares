package ntu.stock.market.sharesbrokering;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class Controller {
	
	@Autowired
	private StockQoutsProxy stockQoutsProxy;
	
	@Autowired
	CurrencyConversionProxy currencyConversioproxy;
	
	@Autowired
	UserSharesProxy userSharesProxy;
	
	@GetMapping("/shares-brokering/currency/{currency}")
	public List<Share> getShares(@PathVariable String currency){
		
		
		List<Share> shares=stockQoutsProxy.getShares();
		
		List<UserShare> userShares= userSharesProxy.getUserShares(1);
		
		for(Share share: shares) {
			
			share.setPrice(currencyConversioproxy.convert(currency, share.getPrice())) ;
			
			UserShare uShare=userShares.stream().filter(userShare->userShare.getShareSymbol().equals(share.getSymbol())).findFirst().orElse(null);
			
			if(uShare!=null) {
				share.setUserSharesCount(uShare.getShareCount());
				double value=Math.round((share.getPrice()*uShare.getShareCount()*100.0))/100.0;
				share.setUserSharesValue(value);
			}
			
		}
		
		
		return shares;
	}

}
