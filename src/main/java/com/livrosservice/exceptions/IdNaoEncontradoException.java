package com.livrosservice.exceptions;

public class IdNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public IdNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
