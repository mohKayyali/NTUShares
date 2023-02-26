package ntu.stock.market.usershares;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	private UserShareRepo repo;
	
	public Controller(UserShareRepo repo) {
		
		this.repo=repo;
	}
	
	
	@GetMapping("/user-shares/userId/{userId}")
	public List<UserShare> getUserShares(@PathVariable int userId){
		
		
		return repo.findByUserId(userId);
	}

}
