package ntu.stock.market.trade;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private UserShareRepo repo;

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

		return true;
	}

}
