package ntu.stock.market.exchangerate;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepo extends JpaRepository<Currency, String>{

}
