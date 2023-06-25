package br.com.deveficente.detalhelivro.domain.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


public class NovoAutorForm {

	@NotBlank
	private String nome;
	@NotBlank
	@URL
	private String linkGit;

	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;

	
	public NovoAutorForm(@NotBlank String nome, @NotBlank @URL String linkGit, @NotNull LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.linkGit = linkGit;
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLinkGit() {
		return linkGit;
	}
	public void setLinkGit(String linkGit) {
		this.linkGit = linkGit;
	}

}
