package br.com.deveficente;

import br.com.deveficente.detalhelivro.domain.entity.SubCategoria;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private SubCategoria categoria;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        categoria = new SubCategoria(null, "Romance");
    }

    @Test
    public void save_success() {

        Mockito.when(categoriaRepository.save(Mockito.any())).thenReturn(categoria);
        NovoCategoriaForm novoCategoriaForm = new NovoCategoriaForm("Romance");
        SubCategoria categoriaNovo =  categoriaService.salvarCategoria(novoCategoriaForm);

        assertNotNull(categoriaNovo);
        assertEquals(categoriaNovo.getNome(), "Romance");
    }
}
