package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Data
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String edicao;
	private String descricao;
	private String imagem;
	private Integer codIsb;

	@Past
	private LocalDate dataLancamento;
	private Double preco;

	private Integer numPaginas;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "LIVRO_CATEGORIA",
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	
	public Livro() {
		super();
	}

	public Livro(Integer id, String nome, String edicao,String descricao, String imagem, Integer codIsb, LocalDate dataLancamento, Double preco, Integer numPaginas) {
		super();
		this.id = id;
		this.nome = nome;
		this.edicao = edicao;
		this.descricao = descricao;
		this.imagem = imagem;
		this.codIsb = codIsb;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.numPaginas = numPaginas;
	}

	public Livro(Integer id, String nome, String edicao, String descricao, String imagem, Integer codIsb, LocalDate dataLancamento, Double preco, Integer numPaginas, List<Categoria> categorias, Autor autor) {
		this.id = id;
		this.nome = nome;
		this.edicao = edicao;
		this.descricao = descricao;
		this.imagem = imagem;
		this.codIsb = codIsb;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.categorias = categorias;
		this.autor = autor;
	}
}
