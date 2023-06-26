package br.com.deveficente.detalhelivro.domain.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.deveficente.detalhelivro.domain.entity.SubCategoria;
import br.com.deveficente.detalhelivro.domain.input.NovoCategoriaForm;
import br.com.deveficente.detalhelivro.domain.service.CategoriaService;

@RestController
public class CrudCategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping(value="/api/categoria")
	public ResponseEntity<Void> novoAutor(@Valid @RequestBody NovoCategoriaForm form) {
		
		SubCategoria categoria = categoriaService.salvarCategoria(form);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/api/categoria")
	public ResponseEntity<List<SubCategoria>> buscarTodasCategorias()throws Exception{
		return ResponseEntity.ok().body(categoriaService.buscarTodos());
	}
}
