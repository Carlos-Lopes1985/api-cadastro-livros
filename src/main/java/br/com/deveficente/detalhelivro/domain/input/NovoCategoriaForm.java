package br.com.deveficente.detalhelivro.domain.input;

import javax.validation.constraints.NotBlank;

public class NovoCategoriaForm {

	@NotBlank
	private String nome;

	public NovoCategoriaForm() {
	}

	public NovoCategoriaForm(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
