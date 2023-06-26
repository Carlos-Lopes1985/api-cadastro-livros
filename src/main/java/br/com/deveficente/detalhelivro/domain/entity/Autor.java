package br.com.deveficente.detalhelivro.domain.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	private String nome;

	@Past
	private LocalDate dataNascimento;

	@URL
	private String linkHomePage;

	@JsonIgnore
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<AudioVisual> livros;

	public Autor(Integer id, String nome, LocalDate dataNascimento, String linkHomePage) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.linkHomePage = linkHomePage;
	}

	public Autor(Integer id, String linkGitHub, List<AudioVisual> livros) {
		this.id = id;
		this.linkHomePage = linkGitHub;
		this.livros = livros;
	}
}
