package br.com.wk.processo.seletivo.sangue.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil findByNome(String nome);
}
