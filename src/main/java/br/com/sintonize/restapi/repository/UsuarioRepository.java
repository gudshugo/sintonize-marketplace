package br.com.sintonize.restapi.repository;

import br.com.sintonize.restapi.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findByUsername(String username);

}
