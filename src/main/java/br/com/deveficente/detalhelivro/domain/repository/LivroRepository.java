package br.com.deveficente.detalhelivro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deveficente.detalhelivro.domain.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
