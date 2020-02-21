package com.example.DSJuQ_Actividad4;

import com.example.DSJuQ_Actividad4.model.Persona;
import com.example.DSJuQ_Actividad4.model.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class DsJuQActividad4Application {

	public static void main(String[] args) {
		SpringApplication.run(DsJuQActividad4Application.class, args);
	}

	@Profile("demo")
	@Bean
	CommandLineRunner initDatabase(PersonaRepository repository) {
		return args -> {
			repository.save(new Persona("DEIVY", "SANCHEZ CORONADO"));
		};
	}
}
