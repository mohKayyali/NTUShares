package ntu.stock.market.sharesbrokering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SharesBrokeringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharesBrokeringApplication.class, args);
	}

}
