package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.model.AlbumDetalhe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query("select count(e.id) from Album e")
    Long checkIfExistsAnyEntry();

    Album findAlbumById(Long id);

    List<Album> findAlbumByIdIn(List<Long> albumsId);

}
