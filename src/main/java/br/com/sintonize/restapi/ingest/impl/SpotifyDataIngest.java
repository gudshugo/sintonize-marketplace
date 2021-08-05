package br.com.sintonize.restapi.ingest.impl;

import br.com.sintonize.restapi.enums.GeneroEnum;
import br.com.sintonize.restapi.ingest.ISpotifyDataIngest;
import br.com.sintonize.restapi.model.Disco;
import br.com.sintonize.restapi.model.Genero;
import br.com.sintonize.restapi.service.IDiscoService;
import br.com.sintonize.restapi.service.IGeneroService;
import br.com.sintonize.restapi.util.UtilMethods;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
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

    private final SpotifyConnection spotifyConnection;

    private final IGeneroService generoService;

    private final IDiscoService discoService;

    @Autowired
    public SpotifyDataIngest(SpotifyConnection spotifyConnection, IGeneroService generoService, IDiscoService discoService){
        this.spotifyConnection = spotifyConnection;
        this.generoService = generoService;
        this.discoService = discoService;
    }

    @PostConstruct
    private void init() throws IOException, SpotifyWebApiException{
        importarDiscos();
    }

    public void importarDiscos() throws IOException, SpotifyWebApiException {

        if(discoService.checkIfExistsAnyEntry() == 0) {

            if (LOGGER.isInfoEnabled()) LOGGER.info("Inicio da importação dos discos da Spotify API.");

            List<Genero> generos = generoService.findGeneros();

                for (Genero genero : generos) {

                    Paging<Track> tracks = spotifyConnection.searchTracks(String.format("genre: %s + year:1995-2021", GeneroEnum.toGender(genero.getDescricao())));

                    List<Disco> discos = Arrays
                            .stream(tracks.getItems())
                            .map(track -> new Disco.Builder()
                                    .withUniqueId(UUID.randomUUID())
                                    .withNome(track.getAlbum().getName())
                                    .withValor(UtilMethods.randomPriceGenerator())
                                    .withGenero(genero)
                                    .build())
                            .limit(50)
                            .collect(Collectors.toList());

                    discoService.saveDiscos(discos);

                }

                if (LOGGER.isInfoEnabled()) LOGGER.info("Fim da importação dos discos da Spotify API.");
            }else{

                if (LOGGER.isInfoEnabled()) LOGGER.info("Importação dos dados do Spotify já foi realizada.");
            }

    }

}


