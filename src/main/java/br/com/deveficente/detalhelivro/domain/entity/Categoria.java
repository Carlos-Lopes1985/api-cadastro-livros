package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@Column(unique=true)
	private String nome;

	@ManyToMany(mappedBy="categorias")
	private List<Livro> livro = new ArrayList<>();

	public Categoria() {
	}

	public Categoria(Integer id, @NotBlank String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
