package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;

@Entity
@Data
public class AudioVisual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String edicao;
	private Integer codIsb;

	@Past
	private LocalDate dataLancamento;

	private Integer numPaginas;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "LIVRO_CATEGORIA",
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<SubCategoria> categorias = new ArrayList<>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

}
