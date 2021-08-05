package br.com.sintonize.restapi.ingest.impl;

import br.com.sintonize.restapi.ingest.ISpotifyDataIngest;
import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.service.IAlbumService;
import br.com.sintonize.restapi.util.UtilMethods;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SpotifyDataIngest implements ISpotifyDataIngest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyDataIngest.class);

    private final SpotifyRequests spotifyRequests;

    private final IAlbumService albumService;

    private final String emptyArtistImage = " ";

    @Autowired
    public SpotifyDataIngest(SpotifyRequests spotifyRequests, IAlbumService albumService){
        this.spotifyRequests = spotifyRequests;
        this.albumService = albumService;
    }

    @PostConstruct
    private void init() throws IOException, SpotifyWebApiException{
        importarAlbums();
    }

    public void importarAlbums() throws IOException, SpotifyWebApiException {

        if(albumService.checkIfExistsAnyEntry() == 0) {

            LOGGER.info("Inicio da importação dos albums da Spotify API.");

            Paging<AlbumSimplified> albumsResponse = spotifyRequests.searchNewAlbums();

            List<Album> albums = Arrays
                    .stream(albumsResponse.getItems())
                    .map(ab -> new Album.Builder()
                            .withUniqueId(UUID.randomUUID())
                            .withNome(ab.getName())
                            .withNomeArtista(!Arrays.asList(ab.getArtists()).isEmpty() ? Arrays.asList(ab.getArtists()).get(0).getName() : "Artista Desconhecido")
                            .withImagem(!Arrays.asList(ab.getImages()).isEmpty() ? Arrays.asList(ab.getImages()).get(0).getUrl() : emptyArtistImage)
                            .withIdApiSpotify(ab.getId())
                            .withLinkSpotify(ab.getExternalUrls().get("spotify"))
                            .withValor(UtilMethods.randomPriceGenerator())
                            .build())
                    .collect(Collectors.toList());

            albumService.saveAlbums(albums);

            LOGGER.info("Fim da importação dos albums da Spotify API.");

        }else{
            LOGGER.info("Importação dos dados do Spotify já foi realizada.");
        }
    }

}


