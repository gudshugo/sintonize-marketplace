package br.com.sintonize.restapi.exception;

import java.util.NoSuchElementException;

public class DiscoNotFoundException extends NoSuchElementException {

    public DiscoNotFoundException(String msg) {
        super(msg);
    }

}
