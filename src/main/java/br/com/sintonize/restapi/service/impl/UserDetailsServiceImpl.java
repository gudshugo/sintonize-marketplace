package br.com.sintonize.restapi.service.impl;

import br.com.sintonize.restapi.exception.UsuarioNotFoundException;
import br.com.sintonize.restapi.model.Usuario;
import br.com.sintonize.restapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByUsername(username));

        if(usuario.isEmpty()){

           throw new UsuarioNotFoundException("Usuário não encontrado.");

        }

        return new User(usuario.get().getUsername(), usuario.get().getPassword(), usuario.get().getAuthorities());

    }




}
