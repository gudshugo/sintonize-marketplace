package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.exception.AlbumNotFoundException;
import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.repository.AlbumRepository;
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

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void saveAlbums(List<Album> albums){
        albumRepository.saveAll(albums);
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
        Optional<Album> album = Optional.ofNullable(albumRepository.findAlbumById(id));

        if(album.isPresent())
            return album.get();

        throw new AlbumNotFoundException(String.format("Album com id: %d não encontrado", id));
    }

    @Override
    public List<Album> findListaAlbumsPorIds(List<Long> albumsId){
        return albumRepository.findAlbumByIdIn(albumsId);
    }

}
