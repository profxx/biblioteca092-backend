package br.com.senai.biblioteca092.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.biblioteca092.entity.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    
}
