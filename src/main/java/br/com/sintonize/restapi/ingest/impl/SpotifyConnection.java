package br.com.sintonize.restapi.ingest.impl;

import br.com.sintonize.restapi.ingest.ISpotifyConnection;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.exceptions.detailed.UnauthorizedException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpotifyConnection implements ISpotifyConnection {

    private static final String clientID = "eee034204d184245bd1147a92e4906e3";
    private static final String clientSecret = "4f1611af4e2c40419db080b2cc16ca52";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientID)
            .setClientSecret(clientSecret)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    private boolean executeAuthentication() {

        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            return true;
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Paging<Track> searchTracks(String genero) throws SpotifyWebApiException, IOException {

        boolean authenticated = executeAuthentication();

        if(authenticated) {
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(genero)
                    .market(CountryCode.PT)
                    .limit(50)
                    .build();

            return searchTracksRequest.execute();
        }

        throw new UnauthorizedException("Falha de autenticação no serviço do Spotify");
    }

}
