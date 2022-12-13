package br.com.wk.processo.seletivo.sangue.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Perfil;
import br.com.wk.processo.seletivo.sangue.controller.modelo.Usuario;
import br.com.wk.processo.seletivo.sangue.controller.repository.PerfilRepository;

public class UsuarioForm {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String Role;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Usuario converterUsuario(PerfilRepository perfilRepository) {
        Perfil padrao = perfilRepository.findByNome(Role);
        return new Usuario(nome, email, new BCryptPasswordEncoder().encode(senha), padrao);
    }

    public UsernamePasswordAuthenticationToken converterDadosLogin() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

}
