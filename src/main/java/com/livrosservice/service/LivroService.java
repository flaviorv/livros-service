package com.livrosservice.service;

import com.livrosservice.exceptions.IdNaoEncontradoException;
import com.livrosservice.model.Livro;
import com.livrosservice.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscar(int id) throws IdNaoEncontradoException {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()) {
            return livro.get();
        }
        throw new IdNaoEncontradoException("Não foi possível encontrar este id de livro");
    }

    public void remover(int id) {
        livroRepository.deleteById(id);
    }

    public void salvar(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro editar(Livro livro) throws IdNaoEncontradoException {
        Livro recuperado = buscar(livro.getId());
        if (livro.getTitulo() != null) {
            recuperado.setTitulo(livro.getTitulo());
        }
        if (livro.getAutor() != null) {
            recuperado.setAutor(livro.getAutor());
        }
        if (livro.getIsbn() != null) {
            recuperado.setIsbn(livro.getIsbn());
        }
        return livroRepository.save(recuperado);
    }
}
