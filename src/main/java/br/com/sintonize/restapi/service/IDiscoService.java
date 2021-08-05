package br.com.sintonize.restapi.service;

import br.com.sintonize.restapi.model.Disco;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDiscoService {

    void saveDiscos(List<Disco> discos);

    Long checkIfExistsAnyEntry();

    Page<Disco> findDiscos(Long generoId, Integer page, Integer linesPerPage, String orderBy, String direction);

    Disco findDisco(Long id);

    List<Disco> findListaDiscosPorIds(List<Long> discosIds);

}
