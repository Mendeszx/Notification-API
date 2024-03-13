package com.api.orquestrador.exceptions;

public class EmailCadastradoException extends RuntimeException {

    public EmailCadastradoException() {
        super("Email ja cadastrado!");
    }

    public EmailCadastradoException(String message) {super(message);}
}
