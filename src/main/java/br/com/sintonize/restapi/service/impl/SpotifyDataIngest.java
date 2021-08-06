package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.mapper.AlbumMapper;
import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.model.AlbumDetalhe;
import br.com.sintonize.restapi.service.IAlbumService;
import br.com.sintonize.restapi.service.ISpotifyDataIngest;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.TrackSimplified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SpotifyDataIngest implements ISpotifyDataIngest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyDataIngest.class);

    private final SpotifyRequests spotifyRequests;

    private final IAlbumService albumService;

    @Autowired
    public SpotifyDataIngest(SpotifyRequests spotifyRequests, IAlbumService albumService){
        this.spotifyRequests = spotifyRequests;
        this.albumService = albumService;
    }

    public void importarAlbums() throws IOException, SpotifyWebApiException {

        if(albumService.checkIfExistsAnyEntry() == 0) {

            LOGGER.info("Inicio da importação dos albums da Spotify API.");

            Paging<AlbumSimplified> albumsResponse = spotifyRequests.searchNewAlbums();

            for (AlbumSimplified ab : albumsResponse.getItems()) {

                Paging<TrackSimplified> tracks = spotifyRequests.searchTracksByAlbum(ab.getId());

                List<AlbumDetalhe> detalhes = AlbumMapper.mapTracksResponseSpotifyToDomain(tracks);

                Album album = AlbumMapper.mapAlbumResponseSpotifyToDomain(ab, detalhes);

                albumService.save(album);

            }

            LOGGER.info("Fim da importação dos albums da Spotify API.");

        }else{
            LOGGER.info("Importação dos dados do Spotify já foi realizada.");
        }
    }

}


