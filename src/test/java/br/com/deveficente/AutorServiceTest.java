package br.com.deveficente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.input.NovoAutorForm;
import br.com.deveficente.detalhelivro.domain.repository.AutorRepository;
import br.com.deveficente.detalhelivro.domain.service.AutorService;

@RunWith(MockitoJUnitRunner.class)
public class AutorServiceTest {

	@Mock
	private AutorRepository autorRepository;
	
	@InjectMocks
	private AutorService autorService;
	
	private Autor autor;
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		
		autor = new Autor(null, "Carlos", LocalDate.now(), "https://git.com.br");
	}
	
	@Test
	public void save_success() {
		
		Mockito.when(autorRepository.save(Mockito.any())).thenReturn(autor);
		NovoAutorForm novoAutorForm = new NovoAutorForm( "Carlos", "carlos@git.com");
		Autor autorNovo =  autorService.salvarAutor(novoAutorForm);

		assertNotNull(autorNovo);
		assertEquals(autorNovo.getNome(), "Carlos");
	}
}
