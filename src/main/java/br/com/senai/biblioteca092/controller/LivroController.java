package br.com.senai.biblioteca092.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.biblioteca092.entity.Livro;
import br.com.senai.biblioteca092.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Livro> insertNew(@RequestBody Livro livro){
        Livro livroInserido = livroService.insertNew(livro);
        return ResponseEntity.ok().body(livroInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
        Livro livroAlterado = livroService.update(id, livro);
        return ResponseEntity.ok().body(livroAlterado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = livroService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
