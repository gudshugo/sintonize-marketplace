package br.com.sintonize.restapi.exception;

import java.util.NoSuchElementException;

public class CashbackNotFoundException extends NoSuchElementException {

    public CashbackNotFoundException(String msg) {
        super(msg);
    }

}
