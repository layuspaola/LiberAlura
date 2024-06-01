package com.paola.literalura;

import com.paola.literalura.principal.Principal;
import com.paola.literalura.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {

	@SpringBootApplication
	public class LiterAluraApplication implements CommandLineRunner {
		@Autowired
		private Repository repository;

		public static void main(String[] args) {
			SpringApplication.run(LiterAluraApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			Principal principal = new Principal(repository);
			principal.mostrarMenu();
		}

	}
}