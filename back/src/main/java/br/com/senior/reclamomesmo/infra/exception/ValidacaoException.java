package br.com.senior.reclamomesmo.infra.exception;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String message) {
        super(message);
    }
}