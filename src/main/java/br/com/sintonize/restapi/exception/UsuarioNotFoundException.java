package br.com.sintonize.restapi.exception;

import java.util.NoSuchElementException;

public class UsuarioNotFoundException extends NoSuchElementException {

    public UsuarioNotFoundException(String msg) {
        super(msg);
    }

}
