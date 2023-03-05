package pl.reservo.reservoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.reservo.reservoservice.security.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ReservoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservoServiceApplication.class, args);
	}

}
