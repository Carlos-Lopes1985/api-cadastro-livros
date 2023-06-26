package br.com.deveficente.detalhelivro.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private BigDecimal preco;
    private String codBarras;
    private String descricao;
    private LocalDate dataManufatura;
    private String imagem;

    @ManyToOne
    @JoinColumn(name="tipo_id")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
}
