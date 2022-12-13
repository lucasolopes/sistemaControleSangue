package br.com.wk.processo.seletivo.sangue.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wk.processo.seletivo.sangue.config.security.TokenService;
import br.com.wk.processo.seletivo.sangue.controller.dto.TokenDto;
import br.com.wk.processo.seletivo.sangue.controller.form.UsuarioForm;
import br.com.wk.processo.seletivo.sangue.controller.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<?> listar() {

        return ResponseEntity.ok().body(usuarioRepository.findById(1l));
    }

    @PostMapping
    public ResponseEntity<TokenDto> cadastrar(@RequestBody @Valid UsuarioForm form) {

        usuarioRepository.save(form.converterUsuario());
        UsernamePasswordAuthenticationToken dadosLogin = form.converterDadosLogin();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
