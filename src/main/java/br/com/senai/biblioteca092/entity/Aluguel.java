package br.com.senai.biblioteca092.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeLocador;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Long idLivro;
    private String status; // ativo, finalizado, atrasado

}
