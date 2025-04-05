package com.happybook.happybook;

import com.happybook.happybook.domain.port.out.BookRepository;
import com.happybook.happybook.infra.out.persistence.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class HappybookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HappybookApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {

		BookEntity book1 = new BookEntity(null, 1, "21/09/1937", "O Hobbit", "Fantasia", 15L, "J.R.R. Tolkien", new BigDecimal("39.90"));
		BookEntity book2 = new BookEntity(null, 1, "08/06/1949", "1984", "Ficção Científica", 20L, "George Orwell", new BigDecimal("45.00"));
		BookEntity book3 = new BookEntity(null, 1, "01/01/1899", "Dom Casmurro", "Romance", 12L, "Machado de Assis", new BigDecimal("30.00"));
		BookEntity book4 = new BookEntity(null, 1, "17/08/1945", "A Revolução dos Bichos", "Ficção", 18L, "George Orwell", new BigDecimal("29.99"));
		BookEntity book5 = new BookEntity(null, 1, "01/01/1866", "Crime e Castigo", "Drama", 10L, "Fiódor Dostoiévski", new BigDecimal("42.50"));
		BookEntity book6 = new BookEntity(null, 1, "28/06/2005", "Percy Jackson e o Ladrão de Raios", "Aventura", 25L, "Rick Riordan", new BigDecimal("35.00"));
		BookEntity book7 = new BookEntity(null, 1, "18/03/2003", "O Código Da Vinci", "Suspense", 14L, "Dan Brown", new BigDecimal("38.00"));
		BookEntity book8 = new BookEntity(null, 1, "26/06/1997", "Harry Potter e a Pedra Filosofal", "Fantasia", 30L, "J.K. Rowling", new BigDecimal("49.99"));
		BookEntity book9 = new BookEntity(null, 1, "03/04/1862", "Os Miseráveis", "Clássico", 8L, "Victor Hugo", new BigDecimal("44.50"));
		BookEntity book10 = new BookEntity(null, 1, "15/09/1986", "It: A Coisa", "Terror", 22L, "Stephen King", new BigDecimal("50.00"));



		bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
	}
}
