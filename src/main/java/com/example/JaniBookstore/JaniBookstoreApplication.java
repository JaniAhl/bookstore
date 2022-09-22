package com.example.JaniBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.JaniBookstore.domain.Book;
import com.example.JaniBookstore.domain.BookRepository;

@SpringBootApplication
public class JaniBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaniBookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			Book b1 = new Book("Pekan kirja", "Pekka", 12345, 50, 1993);
			Book b2 = new Book("Liisan kirja", "Liisa", 54123, 100, 2022);
			Book b3 = new Book("Matin kirja", "Matti", 54321, 20, 1890);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
