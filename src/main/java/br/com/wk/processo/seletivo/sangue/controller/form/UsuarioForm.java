package br.com.wk.processo.seletivo.sangue.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.wk.processo.seletivo.sangue.controller.modelo.User;

public class UsuarioForm {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;

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

    public User converterUsuario() {
        return new User(nome, email, new BCryptPasswordEncoder().encode(senha));
    }

    public UsernamePasswordAuthenticationToken converterDadosLogin() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
