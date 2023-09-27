package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class downloadArquivoNaoEncontradoException extends RuntimeException{
    public downloadArquivoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public downloadArquivoNaoEncontradoException(String mensagem, Throwable causa)  {
        super(mensagem, causa);
    }
}