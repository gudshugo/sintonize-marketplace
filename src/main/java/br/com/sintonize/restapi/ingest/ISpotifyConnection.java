package br.com.sintonize.restapi.ingest;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;

import java.io.IOException;

public interface ISpotifyConnection {

    Paging<Track> searchTracks(String genero) throws SpotifyWebApiException, IOException;

}
