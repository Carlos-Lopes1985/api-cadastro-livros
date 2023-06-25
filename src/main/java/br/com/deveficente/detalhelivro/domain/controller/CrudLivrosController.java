package br.com.deveficente.detalhelivro.domain.controller;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.Categoria;
import br.com.deveficente.detalhelivro.domain.entity.Livro;
import br.com.deveficente.detalhelivro.domain.input.NovoCategoriaForm;
import br.com.deveficente.detalhelivro.domain.input.NovoLivroForm;
import br.com.deveficente.detalhelivro.domain.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CrudLivrosController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value="/api/livros")
    public ResponseEntity<List<Livro>> buscarTodasCategorias()throws Exception{
        return ResponseEntity.ok().body(livroService.buscarTodos());
    }

    @GetMapping(value="/api/livros/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id)throws Exception{

        return ResponseEntity.ok().body(livroService.buscarPorId(id));
    }

    @PostMapping(value="/api/livros")
    public ResponseEntity<Void> novoAutor(@Valid @RequestBody NovoLivroForm form) {

        Livro livro = livroService.salvar(form);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
