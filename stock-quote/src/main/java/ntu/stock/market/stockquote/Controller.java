package ntu.stock.market.stockquote;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



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
	
	@GetMapping("/stock-quote/update/{symbol}/{rate}")
	public boolean updateShare(@PathVariable String symbol,@PathVariable double rate){
		
		 Share share= repo.findById(symbol).orElseGet(null);
		 share.setPrice(rate);
		 share.setLastUpdatedDate(java.time.LocalDateTime.now());
		 
		 repo.save(share);
		 
		 return true;
	}
	
	@PutMapping("/stock-quote/change-availability/operation/{operation}/count/{count}/symbol/{symbol}")
	public boolean updateShare(@PathVariable String operation,@PathVariable int count,@PathVariable String symbol){
		
		 Share share= repo.findById(symbol).orElseGet(null);
		 
		 int available=share.getAvailableShares();
		 
		 if(operation.toLowerCase().equals("buy"))
			 available-=count;
		 else
			 available+=count;
		 
		 share.setAvailableShares(available);
		 
		 
		 repo.save(share);
		 
		 return true;
	}

}
