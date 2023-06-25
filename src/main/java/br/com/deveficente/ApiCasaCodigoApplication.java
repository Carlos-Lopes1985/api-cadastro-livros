package br.com.deveficente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import br.com.deveficente.detalhelivro.domain.entity.Livro;
import br.com.deveficente.detalhelivro.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.Categoria;
import br.com.deveficente.detalhelivro.domain.repository.AutorRepository;
import br.com.deveficente.detalhelivro.domain.repository.CategoriaRepository;

@SpringBootApplication
public class ApiCasaCodigoApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiCasaCodigoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Autor autor = new Autor(null, "Dom Pedro", LocalDate.of(1885, 10, 23), LocalDateTime.now(),"https://github.com/teste");
		Autor autor1 = new Autor(null, "Cleopata", LocalDate.of(1880, 11, 11), LocalDateTime.now(),"https://github.com/teste1");
		Autor autor2 = new Autor(null, "Jam", LocalDate.of(1879, 7, 29), LocalDateTime.now(),"https://github.com/teste2");
		Autor autor3 = new Autor(null, "Hub Nelson", LocalDate.of(1550, 5, 28), LocalDateTime.now(), "https://github.com/teste3");
	
		autorRepository.saveAll(Arrays.asList(autor, autor1,autor2,autor3));
		
		Categoria cat = new Categoria(null, "Ficção");
		Categoria cat1 = new Categoria(null, "Aventura");
		Categoria cat2 = new Categoria(null, "Romance");
		Categoria cat3 = new Categoria(null, "Informática");
		Categoria cat4 = new Categoria(null, "Português");

		Livro livro = new Livro(null,"Cleopata","1","História da princesa","sem",123456,LocalDate.of(2015,10,12),120.,500);
		Livro livro2 = new Livro(null,"Popaye","1","História da princesa","sem",123456,LocalDate.of(2015,10,12),120.,500);
		Livro livro3 = new Livro(null,"Batman","1","História da princesa","sem",123456,LocalDate.of(2015,10,12),120.,500);


		cat.getLivro().addAll(Arrays.asList(livro,livro3));
		cat1.getLivro().addAll(Arrays.asList(livro2));
		cat2.getLivro().addAll(Arrays.asList(livro,livro2,livro3));

		livro.getCategorias().addAll(Arrays.asList(cat,cat2));
		livro2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		livro3.getCategorias().addAll(Arrays.asList(cat,cat2));

		categoriaRepository.saveAll(Arrays.asList(cat, cat1,cat2,cat3,cat4));

		livro.setAutor(autor);
		livro2.setAutor(autor2);
		livro3.setAutor(autor);
		livroRepository.saveAll(Arrays.asList(livro,livro2,livro3));
	}
}
