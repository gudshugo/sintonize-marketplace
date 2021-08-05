package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query("select count(e.id) from Album e")
    Long checkIfExistsAnyEntry();

    Album findAlbumById(Long id);

    List<Album> findAlbumByIdIn(List<Long> albumsId);

}
