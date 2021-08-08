package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.AlbumDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlbumDetalheRepository extends JpaRepository<AlbumDetalhe, Integer> {

    List<AlbumDetalhe> findAlbumDetalheByAlbumId(Long albumId);

}
