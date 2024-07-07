package com.example.oL;

import com.example.oL.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OLApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OLApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.Menu();
	}
}
