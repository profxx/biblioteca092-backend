package br.com.senai.biblioteca092.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.biblioteca092.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
