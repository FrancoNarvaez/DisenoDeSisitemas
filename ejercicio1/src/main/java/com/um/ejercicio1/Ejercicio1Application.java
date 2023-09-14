package com.um.ejercicio1;

import com.um.ejercicio1.Entidades.Domicilio;
import com.um.ejercicio1.Entidades.Persona;
import com.um.ejercicio1.Repositorios.DomicilioRepository;
import com.um.ejercicio1.Repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio1Application {
	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			// Código a ejecutar después de la inicialización de la aplicación
			System.out.println("La aplicación se ha iniciado. Realizando tareas iniciales...");
			Persona p1 = Persona.builder()
					.nombre("Juan")
					.apellido("Perez")
					.edad(30)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Suipacha")
					.numero(30)
					.build();

			p1.setDomicilio(domicilio);
			personaRepository.save(p1);


			Persona personarecuperada = personaRepository.findById(p1.getId()).orElse(null);
			if (personarecuperada != null){
				System.out.println("Nombre: "+ personarecuperada.getNombre());
				System.out.println("Apellido: " + personarecuperada.getApellido());
				System.out.println("Edad: " + personarecuperada.getEdad());
				System.out.println("Id: " + personarecuperada.getId());
			}
		};
	}
}

