package com.livrosservice.controller;

import com.livrosservice.model.Livro;
import com.livrosservice.service.LivroService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {

    private static Logger log = LogManager.getLogger(MarkerManager.Log4jMarker.class);

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> buscarTodos(){
        return livroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable int id){
        try {
            Livro livro = livroService.buscar(id);
            return ResponseEntity.ok(livro);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void salvar(@RequestBody Livro livro){
        livroService.salvar(livro);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable int id, @RequestBody Livro livro){
        livro.setId(id);
        try {
            livroService.editar(livro);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id){
        livroService.remover(id);
    }
}
