package br.com.sintonize.restapi.exception;

import java.util.NoSuchElementException;

public class AlbumNotFoundException extends NoSuchElementException {

    public AlbumNotFoundException(String msg) {
        super(msg);
    }

}
