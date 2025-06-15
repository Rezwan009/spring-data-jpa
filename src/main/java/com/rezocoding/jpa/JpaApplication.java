package com.rezocoding.jpa;

import com.github.javafaker.Faker;
import com.rezocoding.jpa.entites.Author;
import com.rezocoding.jpa.repositories.AuthorRepository;
import com.rezocoding.jpa.repositories.VideoRepository;
import com.rezocoding.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return args -> {
            for (int i = 0; i<50; i++) {
				Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(18,50))
                        .email(faker.internet().emailAddress())
						.createdBy("admin")
                        .createdAt(LocalDateTime.now())
                        .build();
//                authorRepository.save(author);
            }
			/*var video = Video.builder()
					.name("test video")
					.length(10)
					.createdAt(LocalDateTime.now())
					.createdBy("admin")
					.build();
			videoRepository.save(video);*/

			//  authorRepository.updateAuthor(27,1);
			//  authorRepository.findByNamedQuery(27).forEach(System.out::println);
			//	authorRepository.updateByNamedQuery(27);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(22))
					.or(AuthorSpecification.firstnameLike("Bu"));
			authorRepository.findAll(spec).forEach(System.out::println);
		};
	}

}
