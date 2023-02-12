package ntu.stock.market.stockquote;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShareRepo extends JpaRepository<Share, String>{

}
