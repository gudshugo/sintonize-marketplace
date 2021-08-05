package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.Disco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscoRepository extends JpaRepository<Disco, Integer> {

    @Query("select count(e.id) from Disco e")
    Long checkIfExistsAnyEntry();

    Page<Disco> findDiscoByGeneroId(Long generoId, Pageable pageRequest);

    Disco findDiscoById(Long id);

    List<Disco> findDiscoByIdIn(List<Long> discosId);

}
