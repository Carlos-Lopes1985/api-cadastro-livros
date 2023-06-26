package br.com.deveficente.detalhelivro.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToOne
    @JoinColumn(name = "subCategoria_id")
    private SubCategoria subCategoria;

    @OneToMany(mappedBy = "tipo")
    private List<Produto> produtos = new ArrayList<>();

}
