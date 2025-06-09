package com.rezocoding.jpa;

import com.rezocoding.jpa.entites.Author;
import com.rezocoding.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
		return args -> {
			var author = Author.builder()
					.firstName("Rezwan")
					.lastName("Ahmed")
					.age(28)
					.email("devrezo9@gmail.com")
					.createdAt(LocalDateTime.now())
					.build();

			authorRepository.save(author);
		};
	}

}
