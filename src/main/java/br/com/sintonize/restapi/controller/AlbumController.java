package br.com.sintonize.restapi.controller;

import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.service.IAlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Controller para realizar operações com a entidade Album e relacionados a ela.")
public class AlbumController {

    private final IAlbumService albumService;

    @Autowired
    public AlbumController(IAlbumService albumService) {
        this.albumService = albumService;
    }

    @ApiOperation("Endpoint para consultar o catálogo de albums de forma paginada e ordenando de forma crescente pelo nome do album.")
    @GetMapping(value = "/v1/albums", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Album>> findAlbuns(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction){

        Page<Album> albums = albumService.findAlbums(page, linesPerPage, orderBy, direction);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @ApiOperation("Endpoint para consultar o álbum pelo seu identificador")
    @GetMapping(value = "/v1/albums/{albumId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> findAlbum(@PathVariable Long albumId){
        Album album = albumService.findAlbum(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

}
