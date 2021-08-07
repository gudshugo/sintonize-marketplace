package br.com.sintonize.restapi.mapper;

import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.model.AlbumDetalhe;
import br.com.sintonize.restapi.util.UtilMethods;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.TrackSimplified;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AlbumMapper {

    //TODO Recuperar imagem vazia de um bucket no S3
    private final String emptyArtistImage = " ";

    public static List<AlbumDetalhe> mapTracksResponseSpotifyToDomain (Paging<TrackSimplified> tracks){

        return Arrays.stream(tracks.getItems())
                .map(tr -> new AlbumDetalhe.Builder()
                        .withNome(tr.getName())
                        .withDuracao(tr.getDurationMs())
                        .withNumero(tr.getTrackNumber())
                        .withPreview(tr.getPreviewUrl())
                        .build())
                .collect(Collectors.toList());

    }

    public static Album mapAlbumResponseSpotifyToDomain (AlbumSimplified ab, List<AlbumDetalhe> detalhes){

        return new Album.Builder()
                .withNome(ab.getName())
                .withNomeArtista(!Arrays.asList(ab.getArtists()).isEmpty() ? Arrays.asList(ab.getArtists()).get(0).getName() : "Artista Desconhecido")
                .withImagem(!Arrays.asList(ab.getImages()).isEmpty() ? Arrays.asList(ab.getImages()).get(0).getUrl() : emptyArtistImage)
                .withIdApiSpotify(ab.getId())
                .withLinkSpotify(ab.getExternalUrls().get("spotify"))
                .withValor(UtilMethods.randomPriceGenerator())
                .withAlbumDetalhes(detalhes)
                .build();
    }

}
