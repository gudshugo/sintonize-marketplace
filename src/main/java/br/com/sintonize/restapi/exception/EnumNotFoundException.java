package br.com.sintonize.restapi.exception;

import java.util.NoSuchElementException;

public class EnumNotFoundException extends NoSuchElementException {

    public EnumNotFoundException(String msg) {
        super(msg);
    }

}
