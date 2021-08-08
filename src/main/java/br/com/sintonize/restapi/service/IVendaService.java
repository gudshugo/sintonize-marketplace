package br.com.sintonize.restapi.service;

import br.com.sintonize.restapi.model.ItemAlbumVenda;
import br.com.sintonize.restapi.model.Venda;

import java.util.List;

public interface IVendaService {

    void saveVenda(List<ItemAlbumVenda> itens);

}
