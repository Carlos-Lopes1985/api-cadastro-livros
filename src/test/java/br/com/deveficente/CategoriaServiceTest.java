package br.com.deveficente;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.Categoria;
import br.com.deveficente.detalhelivro.domain.input.NovoAutorForm;
import br.com.deveficente.detalhelivro.domain.input.NovoCategoriaForm;
import br.com.deveficente.detalhelivro.domain.repository.CategoriaRepository;
import br.com.deveficente.detalhelivro.domain.service.CategoriaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria categoria;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        categoria = new Categoria(null, "Romance");
    }

    @Test
    public void save_success() {

        Mockito.when(categoriaRepository.save(Mockito.any())).thenReturn(categoria);
        NovoCategoriaForm novoCategoriaForm = new NovoCategoriaForm("Romance");
        Categoria categoriaNovo =  categoriaService.salvarCategoria(novoCategoriaForm);

        assertNotNull(categoriaNovo);
        assertEquals(categoriaNovo.getNome(), "Romance");
    }
}
