package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.model.Album;
import br.com.sintonize.restapi.model.ItemAlbumVenda;
import br.com.sintonize.restapi.model.dto.AlbumListaDTO;
import br.com.sintonize.restapi.service.IAlbumService;
import br.com.sintonize.restapi.service.ICashbackService;
import br.com.sintonize.restapi.service.IItemAlbumVendaService;
import br.com.sintonize.restapi.util.UtilMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemAlbumVendaService implements IItemAlbumVendaService {

    private final IAlbumService albumService;

    private final VendaService vendaService;

    private final ICashbackService cashbackService;

    @Autowired
    public ItemAlbumVendaService(IAlbumService albumService, VendaService vendaService, ICashbackService cashbackService) {
        this.albumService = albumService;
        this.vendaService = vendaService;
        this.cashbackService = cashbackService;
    }

    @Override
    public void saveItemVendaAlbum(AlbumListaDTO albumListaDTO) {

        List<Album> albuns = albumService.findListaAlbumsPorIds(albumListaDTO.getAlbumsId());

        BigDecimal cashback = cashbackService.recuperarValorCashbackAtual();

        List<ItemAlbumVenda> itens = albuns.stream()
                .map(item -> new ItemAlbumVenda.Builder()
                .withAlbum(item)
                .withValorVenda(item.getValor())
                .withValorCashback(item.getValor().multiply(cashback))
                .withCodigoVenda(UtilMethods.randomOrderNumberGenerator())
                .build())
                .collect(Collectors.toList());

        vendaService.saveVenda(itens);

    }


}
