package br.com.sintonize.restapi.service;

import br.com.sintonize.restapi.model.Album;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAlbumService {

    void saveAlbums(List<Album> albums);

    Long checkIfExistsAnyEntry();

    Page<Album> findAlbums(Integer page, Integer linesPerPage, String orderBy, String direction);

    Album findAlbum(Long id);

    List<Album> findListaAlbumsPorIds(List<Long> albumsId);

}
