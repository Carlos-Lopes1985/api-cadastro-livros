package br.com.deveficente.detalhelivro.domain.service;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.SubCategoria;
import br.com.deveficente.detalhelivro.domain.entity.AudioVisual;
import br.com.deveficente.detalhelivro.domain.input.NovoLivroForm;
import br.com.deveficente.detalhelivro.domain.repository.LivroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<AudioVisual> buscarTodos(){
        return livroRepository.findAll();
    }

    public AudioVisual buscarPorId(Integer id) throws ObjectNotFoundException {

        Optional<AudioVisual> autor = livroRepository.findById(id);
        return livroRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ "Tipo: " + AudioVisual.class, null));
    }

    public AudioVisual salvar(@Valid NovoLivroForm form) {
        return livroRepository.save(converteFormParaLivro(form));
    }

    private AudioVisual converteFormParaLivro(NovoLivroForm form) {

        Autor autor = new Autor();
        SubCategoria categoria = new SubCategoria();
        categoria.setId(form.getIdCategoria());
        List<SubCategoria> categorias = new ArrayList<>();

        autor.setId(form.getIdAutor());
        categorias.addAll(Arrays.asList(categoria));
        return null;
        //return new AudioVisual(null,form.getNome(), form.getEdicao(), form.getDescricao(), form.getImagem(), form.getCodIsb(),form.getDataLancamento(),form.getPreco(),form.getNumPaginas(),categorias,autor);
    }
}
