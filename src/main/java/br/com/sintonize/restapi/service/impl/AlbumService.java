package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.exception.AlbumNotFoundException;
import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.model.AlbumDetalhe;
import br.com.sintonize.restapi.repository.IAlbumDetalheRepository;
import br.com.sintonize.restapi.repository.IAlbumRepository;
import br.com.sintonize.restapi.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements IAlbumService {

    private final IAlbumRepository albumRepository;

    private final IAlbumDetalheRepository albumDetalheRepository;

    @Autowired
    public AlbumService(IAlbumRepository albumRepository, IAlbumDetalheRepository albumDetalheRepository) {
        this.albumRepository = albumRepository;
        this.albumDetalheRepository = albumDetalheRepository;
    }

    @Override
    public void save(Album album){
        albumRepository.save(album);
    }

    @Override
    public Long checkIfExistsAnyEntry(){
        return albumRepository.checkIfExistsAnyEntry();
    }

    @Override
    public Page<Album> findAlbums(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return albumRepository.findAll(pageRequest);
    }

    @Override
    public Album findAlbum(Long id){
        return Optional.ofNullable(albumRepository.findAlbumById(id))
                .orElseThrow(() -> new AlbumNotFoundException(String.format("Album com id: %d não encontrado", id)));
    }

    @Override
    public List<Album> findListaAlbumsPorIds(List<Long> albumsId){
        return albumRepository.findAlbumByIdIn(albumsId);
    }


    @Override
    public List<AlbumDetalhe> findDetalheById(Long albumId){
        return albumDetalheRepository.findAlbumDetalheByAlbumId(albumId);
    }

}
