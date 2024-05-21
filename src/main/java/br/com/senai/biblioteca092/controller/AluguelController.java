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

import br.com.senai.biblioteca092.entity.Aluguel;
import br.com.senai.biblioteca092.entity.Livro;
import br.com.senai.biblioteca092.service.AluguelService;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/listar")
    public ResponseEntity<List<Aluguel>> findAll(){
        List<Aluguel> alugueis = aluguelService.findAll();
        return ResponseEntity.ok().body(alugueis);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id){
        Aluguel aluguel = aluguelService.findById(id);
        return ResponseEntity.ok().body(aluguel);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Aluguel> insertNew(@RequestBody Aluguel aluguel){
        Aluguel aluguelInserido = aluguelService.insertNew(aluguel);
        return ResponseEntity.ok().body(aluguelInserido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> update(@PathVariable Long id, @RequestBody Aluguel aluguel){
        Aluguel aluguelAlterado = aluguelService.update(id, aluguel);
        return ResponseEntity.ok().body(aluguelAlterado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = aluguelService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
    
}
