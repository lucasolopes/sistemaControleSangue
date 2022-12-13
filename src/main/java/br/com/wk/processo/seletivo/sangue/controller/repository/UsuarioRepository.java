package br.com.wk.processo.seletivo.sangue.controller.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
