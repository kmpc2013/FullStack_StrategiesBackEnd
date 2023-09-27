package com.example.demo.exception;

public class uploadArquivoException extends RuntimeException{
    public uploadArquivoException(String mensagem) {
        super(mensagem);
    }
    public uploadArquivoException(String mensagem, Throwable causa)  {
        super(mensagem, causa);
    }
}
