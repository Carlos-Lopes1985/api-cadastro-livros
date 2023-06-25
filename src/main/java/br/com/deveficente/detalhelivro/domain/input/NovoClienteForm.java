package br.com.deveficente.detalhelivro.domain.input;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class NovoClienteForm {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @Past
    private LocalDate dataNascimento;

    @Past
    private LocalDate dataCadastro;
    
}
