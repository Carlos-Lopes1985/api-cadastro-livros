package br.com.deveficente.detalhelivro.domain.input;

import br.com.deveficente.detalhelivro.domain.entity.Autor;
import br.com.deveficente.detalhelivro.domain.entity.Categoria;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Data
public class NovoLivroForm {


    private String nome;
    private String edicao;
    private String descricao;
    private String imagem;
    private Integer codIsb;
    private LocalDate dataLancamento;
    private Double preco;
    private Integer numPaginas;
    private Integer idCategoria;
    private Integer idAutor;
}
