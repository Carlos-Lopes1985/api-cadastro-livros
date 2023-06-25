package br.com.deveficente.detalhelivro.domain.response;

import java.time.LocalDate;

public class LivroResponseDto {

    private String nome;
    private String edicao;
    private String descricao;
    private String imagem;
    private Integer codIsb;
    private LocalDate dataLancamento;
    private Double preco;
}
