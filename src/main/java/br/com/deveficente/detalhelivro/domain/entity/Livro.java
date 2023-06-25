package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@ManyToOne
	private @NotNull Categoria categoria;
	
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

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Integer getCodIsb() {
		return codIsb;
	}

	public void setCodIsb(Integer codIsb) {
		this.codIsb = codIsb;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
