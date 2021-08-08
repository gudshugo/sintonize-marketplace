package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Integer> {

}
