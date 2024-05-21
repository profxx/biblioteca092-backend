package br.com.senai.biblioteca092.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.biblioteca092.entity.Livro;
import br.com.senai.biblioteca092.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public Livro insertNew(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro update(Long id, Livro livro){
        Livro livroAtual = findById(id);
        livroAtual.setAutor(livro.getAutor());
        livroAtual.setIsbn(livro.getIsbn());
        livroAtual.setTitulo(livro.getTitulo());
        livroAtual.setQuantidade(livro.getQuantidade());
        livroAtual.setDataPublicacao(livro.getDataPublicacao());
        return livroRepository.save(livroAtual);
    }

    public Boolean deleteById(Long id){
        Livro livro = findById(id);
        if (livro == null){
            return false;
        }else{
            livroRepository.deleteById(id);
            return true;
        }
    }
}
