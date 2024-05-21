package br.com.senai.biblioteca092.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.biblioteca092.entity.Aluguel;
import br.com.senai.biblioteca092.entity.Livro;
import br.com.senai.biblioteca092.repository.AluguelRepository;
import br.com.senai.biblioteca092.repository.LivroRepository;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Aluguel> findAll(){
        return aluguelRepository.findAll();
    }
    public Aluguel findById(Long id){
        return aluguelRepository.findById(id).orElse(null);
    }
    public Aluguel novoAluguel(Aluguel aluguel){
        Livro livro = livroRepository.findById(aluguel.getIdLivro()).orElse(null);
        if (livro == null){
            return null;
        }else{
            int quantidadeAtual = livro.getQuantidade();
            livro.setQuantidade(quantidadeAtual - 1);
            aluguel.setDataLocacao(LocalDate.now());
            aluguel.setDataDevolucao(LocalDate.now().plusDays(10));
            aluguel.setStatus("ativo");
            return aluguelRepository.save(aluguel);
        }   
    }
    public Aluguel update(Long id, Aluguel aluguelAlterado){
        Aluguel aluguelAtual = findById(id);
        aluguelAtual.setNomeLocador(aluguelAlterado.getNomeLocador());
        aluguelAtual.setDataLocacao(aluguelAlterado.getDataLocacao());
        aluguelAtual.setIdLivro(aluguelAlterado.getIdLivro());
        return aluguelRepository.save(aluguelAtual);
    }
    public Aluguel encerraAluguel(Long id){
        Aluguel aluguel = findById(id);
        if (aluguel == null){
            return null;
        }else{
            Livro livro = livroRepository.findById(aluguel.getIdLivro()).orElse(null);
            if (livro != null){
                int quantidadeAtual = livro.getQuantidade();
                livro.setQuantidade(quantidadeAtual + 1);
                aluguel.setStatus("finalizado");
                aluguel.setDataDevolucao(LocalDate.now());
            }
            return aluguelRepository.save(aluguel);
        }
    }
    public Boolean deleteById(Long id){
        Aluguel aluguel = findById(id);
        if (aluguel == null){
            return false;
        }else{
            aluguelRepository.deleteById(id);
            return true;
        }
    }
}
