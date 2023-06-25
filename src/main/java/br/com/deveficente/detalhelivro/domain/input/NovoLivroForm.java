package br.com.deveficente.detalhelivro.domain.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

public class NovoLivroForm {

    @NotBlank
    private String nome;
    private String edicao;
    private String descricao;
    private String imagem;

    @NotBlank
    private Integer codIsb;

    @Past
    private LocalDate dataLancamento;
    private Double preco;

    private Integer categoria;

    private List<Integer> autores;
}
