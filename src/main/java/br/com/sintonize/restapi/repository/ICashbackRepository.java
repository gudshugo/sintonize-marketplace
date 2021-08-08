package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.enums.DiaEnum;
import br.com.sintonize.restapi.enums.MesEnum;
import br.com.sintonize.restapi.model.Cashback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ICashbackRepository extends JpaRepository<Cashback, Integer> {

    @Query(value = "SELECT c.valor FROM Cashback c where c.dia = :dia and c.mes = :mes", nativeQuery = true)
    BigDecimal findValorByDiaAndMes(int dia, int mes);

}
