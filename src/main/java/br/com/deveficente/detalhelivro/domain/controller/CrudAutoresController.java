package br.com.deveficente.detalhelivro.domain.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.input.NovoAutorForm;
import br.com.deveficente.detalhelivro.domain.service.AutorService;

@RestController
public class CrudAutoresController {
	
	@Autowired
	private AutorService autorService;
	
	@PostMapping(value="/api/autor")
	public ResponseEntity<Void> novoAutor(@Valid @RequestBody NovoAutorForm form) {
		
		Autor autor = autorService.salvarAutor(form);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/api/autor")
	public ResponseEntity<List<Autor>> buscarTodosAutores()throws Exception{
		
		return ResponseEntity.ok().body(autorService.buscarTodos());
	}

	@GetMapping(value="/api/autor/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable Integer id)throws Exception{

		return ResponseEntity.ok().body(autorService.buscarPorId(id));
	}
	
	
}
