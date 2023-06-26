package br.com.deveficente.detalhelivro.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.input.NovoAutorForm;
import br.com.deveficente.detalhelivro.domain.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public Autor salvarAutor(@Valid NovoAutorForm form) {
		
		return autorRepository.save(converteFormParaAutor(form));
	}

	private Autor converteFormParaAutor(@Valid NovoAutorForm form) {

		return null;
		//return new Autor(null, form.getNome(),form.getDataNascimento(), LocalDateTime.now(),form.getLinkGit());
	}

	public List<Autor> buscarTodos() {
		return autorRepository.findAll();
	}


	public Autor buscarPorId(Integer id) throws ObjectNotFoundException {

		Optional<Autor> autor = autorRepository.findById(id);
		return autorRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ "Tipo: " +Autor.class, null));
	}
}
