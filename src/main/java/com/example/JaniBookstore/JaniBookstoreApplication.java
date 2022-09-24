package com.example.JaniBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.JaniBookstore.domain.Book;
import com.example.JaniBookstore.domain.BookRepository;
import com.example.JaniBookstore.domain.Category;
import com.example.JaniBookstore.domain.CategoryRepository;

@SpringBootApplication
public class JaniBookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(JaniBookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaniBookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Drama"));
			
			repository.save(new Book("Pekan kirja", "Pekka", 12345, 50, 1993, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Liisan kirja", "Liisa", 54123, 100, 2022, crepository.findByName("Horror").get(0)));
			repository.save(new Book("Matin kirja", "Matti", 54321, 20, 1890, crepository.findByName("Fantasy").get(0)));
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
