package br.com.deveficente.detalhelivro.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@Column(unique=true)
	private String nome;

	@ManyToMany(mappedBy="categorias")
	private List<AudioVisual> livro = new ArrayList<>();

	@OneToOne(mappedBy = "subCategoria", cascade = CascadeType.ALL)
	private Tipo tipo;

	public SubCategoria() {
	}

	public SubCategoria(Integer id, @NotBlank String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
