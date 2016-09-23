package pl.marchuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlApiApplication {

	public static void main(String[] args) {

		// Tell Boot to look for registration-server.yml
		System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(CrawlApiApplication.class, args);
	}
}
