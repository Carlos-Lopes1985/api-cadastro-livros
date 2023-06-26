package br.com.deveficente.detalhelivro.domain.input;

import lombok.Data;

import java.time.LocalDate;

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
