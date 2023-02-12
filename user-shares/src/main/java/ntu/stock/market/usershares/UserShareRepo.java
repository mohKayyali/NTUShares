package ntu.stock.market.usershares;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserShareRepo extends JpaRepository<UserShare, Integer>{
	
	 List<UserShare> findByUserId(int userId);

}
