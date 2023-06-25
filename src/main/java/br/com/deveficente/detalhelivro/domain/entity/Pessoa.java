package br.com.deveficente.detalhelivro.domain.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataNascimento;

    private LocalDateTime datacadastro;

    public Pessoa(Integer id, String nome, LocalDate dataNascimento, LocalDateTime datacadastro) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.datacadastro = datacadastro;
    }

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalDateTime getDatacadastro() {
        return datacadastro;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDatacadastro(LocalDateTime datacadastro) {
        this.datacadastro = datacadastro;
    }
}
