package br.com.wk.processo.seletivo.sangue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wk.processo.seletivo.sangue.controller.dto.CandidatosDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.ImcObesidadePorSexoDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.ImcPorFaixaIdadeDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.PossiveisDoadoresDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.QuantidateTipoSanquineoDto;
import br.com.wk.processo.seletivo.sangue.controller.form.CandidatosForm;
import br.com.wk.processo.seletivo.sangue.controller.repository.CandidatosPorEstado;
import br.com.wk.processo.seletivo.sangue.controller.services.CandidatosServices;

@RestController
@RequestMapping("/candidatos")
public class CandidatosController {

    @Autowired
    private CandidatosServices candidatosServices;

    @GetMapping
    public Page<CandidatosDto> lista(
            @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        return candidatosServices.listarTodos(paginacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CandidatosDto> cadastrar(@RequestBody @Valid ArrayList<CandidatosForm> form) {
        candidatosServices.cadastrar(form);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estado")
    public ResponseEntity<List<CandidatosPorEstado>> candidatosPorEstado() {
        return ResponseEntity.ok().body(candidatosServices.quantidadeCandidatosPorEstado());
    }

    @GetMapping("/imcmedio")
    public ResponseEntity<List<ImcPorFaixaIdadeDto>> imcMedio() {
        return ResponseEntity.ok().body(candidatosServices.calcularImcPorIdade(candidatosServices.ImcMedioPorIdade()));
    }

    @GetMapping("/percentualObesidade")
    public ResponseEntity<List<ImcObesidadePorSexoDto>> percentualObesidadePorSexo() {
        return ResponseEntity.ok().body(candidatosServices.percentualObesos(candidatosServices.ImcMedioPorIdade()));
    }

    @GetMapping("/mediaIdadeTipoSanguineo")
    public ResponseEntity<List<QuantidateTipoSanquineoDto>> mediaIdadeTipoSanguineo() {
        return ResponseEntity.ok().body(candidatosServices.tipoSanguineo());
    }

    @GetMapping("/quantidadeDoadores")
    public ResponseEntity<List<PossiveisDoadoresDto>> quantidadeDoadores() {
        return ResponseEntity.ok().body(candidatosServices.possiveisReceptores());
    }

}
