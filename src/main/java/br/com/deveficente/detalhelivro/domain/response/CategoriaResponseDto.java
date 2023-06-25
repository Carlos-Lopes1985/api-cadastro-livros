package br.com.deveficente.detalhelivro.domain.response;

public class CategoriaResponseDto {

    private String nome;

    public CategoriaResponseDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
