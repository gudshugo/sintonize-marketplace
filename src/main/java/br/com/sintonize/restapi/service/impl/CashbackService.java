package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.enums.DiaEnum;
import br.com.sintonize.restapi.enums.MesEnum;
import br.com.sintonize.restapi.exception.CashbackNotFoundException;
import br.com.sintonize.restapi.repository.ICashbackRepository;
import br.com.sintonize.restapi.service.ICashbackService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CashbackService implements ICashbackService {

    private final ICashbackRepository cashbackRepository;

    public CashbackService(ICashbackRepository cashbackRepository) {
        this.cashbackRepository = cashbackRepository;
    }

    @Override
    public BigDecimal recuperarValorCashbackAtual() {

        LocalDate data = LocalDate.now();

        return Optional.ofNullable(cashbackRepository.findValorByDiaAndMes(DiaEnum.toEnumValue(data), MesEnum.toEnumValue(data)))
                .orElseThrow(() -> new CashbackNotFoundException(String.format("Cashback com os parâmetros: dia -> %d  e mês -> %d não encontrados",
                        data.getDayOfMonth(), data.getMonthValue())));
    }
}
