package br.com.sintonize.restapi.service;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

public interface ISpotifyDataIngest {

    void importarAlbums() throws IOException, SpotifyWebApiException;

}
