package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.model.ItemAlbumVenda;
import br.com.sintonize.restapi.model.Venda;
import br.com.sintonize.restapi.repository.IVendaRepository;
import br.com.sintonize.restapi.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService implements IVendaService {

    private final IVendaRepository vendaRepository;

    @Autowired
    public VendaService(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public void saveVenda(List<ItemAlbumVenda> itens) {

        BigDecimal totalVenda = itens.stream()
                .map(ItemAlbumVenda::getValorVenda)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCashback = itens.stream()
                .map(ItemAlbumVenda::getValorCashback)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Venda v = new Venda.Builder()
                .withDataVenda(LocalDate.now())
                .withValorVenda(totalVenda)
                .withValorCashback(totalCashback)
                .withItemAlbumVendas(itens)
                .build();

        vendaRepository.save(v);

    }


}
