package br.com.springboot.ws.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FootballMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballMatchApplication.class, args);
		
	}
}
