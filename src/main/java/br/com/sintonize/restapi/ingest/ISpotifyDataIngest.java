package br.com.sintonize.restapi.ingest;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

public interface ISpotifyDataIngest {

    void importarDiscos() throws IOException, SpotifyWebApiException;

}
