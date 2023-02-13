package ntu.stock.market.trade;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserShareRepo extends JpaRepository<UserShare, Integer>{
	
	public UserShare findByShareSymbolAndUserId(String shareSymbol, int userId);

}
