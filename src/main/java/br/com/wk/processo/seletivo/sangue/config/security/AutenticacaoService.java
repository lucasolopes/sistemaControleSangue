package br.com.wk.processo.seletivo.sangue.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Usuario;
import br.com.wk.processo.seletivo.sangue.controller.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);
        if (usuario.isPresent())
            return usuario.get();

        throw new UsernameNotFoundException("Dados invalidos");
    }

}
