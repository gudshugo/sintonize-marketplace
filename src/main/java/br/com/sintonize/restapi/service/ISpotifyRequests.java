package br.com.sintonize.restapi.service;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.TrackSimplified;

import java.io.IOException;

public interface ISpotifyRequests {

    Paging<TrackSimplified> searchTracksByAlbum(String id) throws SpotifyWebApiException, IOException;

    Paging<AlbumSimplified> searchNewAlbums() throws SpotifyWebApiException, IOException;

}
