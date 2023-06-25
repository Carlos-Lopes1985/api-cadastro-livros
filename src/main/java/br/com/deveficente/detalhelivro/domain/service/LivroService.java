package br.com.deveficente.detalhelivro.domain.service;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.Livro;
import br.com.deveficente.detalhelivro.domain.repository.LivroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Integer id) throws ObjectNotFoundException {

        Optional<Livro> autor = livroRepository.findById(id);
        return livroRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ "Tipo: " +Livro.class, null));
    }
}
