package ntu.stock.market.sharesbrokering;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="user-shares", url="localhost:6003")
public interface UserSharesProxy {
	
	@GetMapping("/user-shares/userId/{userId}")
	public List<UserShare> getUserShares(@PathVariable int userId);

}
