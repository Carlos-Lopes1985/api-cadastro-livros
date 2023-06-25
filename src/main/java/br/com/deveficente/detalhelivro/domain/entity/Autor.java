package br.com.deveficente.detalhelivro.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@JsonTypeName("autor")
public class Autor extends Pessoa {
	

	@URL
	private String linkGitHub;
	
	@JsonIgnore
	@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
	private List<Livro>livros;

	public Autor(Integer id, String nome, LocalDate dataNascimento, LocalDateTime datacadastro, String linkGitHub) {
		super(id, nome, dataNascimento, datacadastro);
		this.linkGitHub = linkGitHub;
	}

	public Autor() {
		// TODO Auto-generated constructor stub
	}


	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
