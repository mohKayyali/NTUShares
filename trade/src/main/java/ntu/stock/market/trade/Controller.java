package ntu.stock.market.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class Controller {

	private UserShareRepo repo;
	
	@Autowired
	private StockQuoteProxy stockQuoteProxy;

	public Controller(UserShareRepo repo) {

		this.repo = repo;
	}

	@PostMapping("/trade/buy")
	public boolean buy(@RequestBody UserShare userShare) {

		UserShare userShareStored = repo.findByShareSymbolAndUserId(userShare.getShareSymbol(), userShare.getUserId());

		if (userShareStored == null) {
			userShareStored = new UserShare();
			userShareStored.setShareSymbol(userShare.getShareSymbol());
			userShareStored.setUserId(userShare.getUserId());
			userShareStored.setShareCount(userShare.getShareCount());
		} else
			userShareStored.setShareCount(userShareStored.getShareCount() + userShare.getShareCount());

		repo.save(userShareStored);
		
		stockQuoteProxy.updateShare("buy", userShare.getShareCount(), userShare.getShareSymbol());

		return true;
	}
	
	@PostMapping("/trade/sell")
	public boolean sell(@RequestBody UserShare userShare) {

		UserShare userShareStored = repo.findByShareSymbolAndUserId(userShare.getShareSymbol(), userShare.getUserId());

		if (userShareStored == null) {
			userShareStored = new UserShare();
			userShareStored.setShareSymbol(userShare.getShareSymbol());
			userShareStored.setUserId(userShare.getUserId());
			userShareStored.setShareCount(userShare.getShareCount());
		} else
			userShareStored.setShareCount(userShareStored.getShareCount() - userShare.getShareCount());

		repo.save(userShareStored);
		
		stockQuoteProxy.updateShare("sell", userShare.getShareCount(), userShare.getShareSymbol());

		return true;
	}

}
