package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@Column(unique=true)
	private String nome;

//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "livro_id")
//	private Livro livro;

	public Categoria() {
	}

	public Categoria(Integer id, @NotBlank String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Livro getLivro() {
//		return livro;
//	}
//
//	public void setLivro(Livro livro) {
//		this.livro = livro;
//	}
}
