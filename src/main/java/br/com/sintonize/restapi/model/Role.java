package br.com.sintonize.restapi.model;

import br.com.sintonize.restapi.enums.TipoRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome")
    private TipoRole role;

    @Override
    public String getAuthority() {
        return this.role.getDescricao();
    }

}
