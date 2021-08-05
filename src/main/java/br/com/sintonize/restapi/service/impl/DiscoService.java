package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.exception.DiscoNotFoundException;
import br.com.sintonize.restapi.model.Disco;
import br.com.sintonize.restapi.repository.DiscoRepository;
import br.com.sintonize.restapi.service.IDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscoService implements IDiscoService {

    private final DiscoRepository discoRepository;

    @Autowired
    public DiscoService(DiscoRepository discoRepository) {
        this.discoRepository = discoRepository;
    }

    @Override
    public void saveDiscos(List<Disco> discos){
        discoRepository.saveAll(discos);
    }

    @Override
    public Long checkIfExistsAnyEntry(){
        return discoRepository.checkIfExistsAnyEntry();
    }

    @Override
    public Page<Disco> findDiscos(Long generoId, Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return discoRepository.findDiscoByGeneroId(generoId, pageRequest);
    }

    @Override
    public Disco findDisco(Long id){
        Optional<Disco> disco = Optional.ofNullable(discoRepository.findDiscoById(id));

        if(disco.isPresent())
            return disco.get();

        throw new DiscoNotFoundException(String.format("Disco com id: %d não encontrado", id));
    }

    @Override
    public List<Disco> findListaDiscosPorIds(List<Long> discosIds){
        return discoRepository.findDiscoByIdIn(discosIds);
    }

}
