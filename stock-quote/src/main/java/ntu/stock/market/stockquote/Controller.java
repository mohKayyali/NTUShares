package ntu.stock.market.stockquote;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class Controller {
	
	ShareRepo repo;
	
	public Controller(ShareRepo repo) {
		this.repo=repo;
	}
	
	@GetMapping("/stock-quote")
	public List<Share> getShares(){
		
		return repo.findAll();
	}

}
