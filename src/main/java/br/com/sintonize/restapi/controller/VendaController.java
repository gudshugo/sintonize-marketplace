package br.com.sintonize.restapi.controller;

import br.com.sintonize.restapi.model.dto.AlbumListaDTO;
import br.com.sintonize.restapi.service.IItemAlbumVendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Resource para realizar operações com a entidade Venda e relacionados a ela.")
public class VendaController {

    private final IItemAlbumVendaService itemAlbumVendaService;

    @Autowired
    public VendaController(IItemAlbumVendaService itemAlbumVendaService) {
        this.itemAlbumVendaService = itemAlbumVendaService;
    }

    @ApiOperation("Endpoint para registrar uma nova venda de discos calculando o valor total de cashback.")
    @PostMapping(value = "/v1/venda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> vendaDiscos(@RequestBody AlbumListaDTO albumLista){
        itemAlbumVendaService.saveItemVendaAlbum(albumLista);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
