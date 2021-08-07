package br.com.sintonize.restapi.controller;

import br.com.sintonize.restapi.service.ISpotifyDataIngest;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/carga")
@Api("Controller responsável pela ingestão de dados consumidos da API do Spotify para construção da base de dados.")
public class IngestController {

    private final ISpotifyDataIngest iSpotifyDataIngest;

    @Autowired
    public IngestController(ISpotifyDataIngest iSpotifyDataIngest) {
        this.iSpotifyDataIngest = iSpotifyDataIngest;
    }

    @ApiOperation("Endpoint que faz ingestão de dados referente a albuns consumidos da API do spotify.")
    @PostMapping(value = "/albums", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> ingestAlbums() throws IOException, SpotifyWebApiException {
        iSpotifyDataIngest.importarAlbums();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
