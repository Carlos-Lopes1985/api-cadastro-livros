package br.com.deveficente.detalhelivro.domain.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deveficente.detalhelivro.domain.entity.SubCategoria;
import br.com.deveficente.detalhelivro.domain.input.NovoCategoriaForm;
import br.com.deveficente.detalhelivro.domain.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public SubCategoria salvarCategoria(@Valid NovoCategoriaForm form) {
		return categoriaRepository.save(converteFormParaCategoria(form));
	}

	private SubCategoria converteFormParaCategoria(@Valid NovoCategoriaForm form) {
		return new SubCategoria(null, form.getNome());
	}
	
	public List<SubCategoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

}
