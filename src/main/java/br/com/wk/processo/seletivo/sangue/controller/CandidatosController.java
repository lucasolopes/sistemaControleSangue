package br.com.wk.processo.seletivo.sangue.controller;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@Validated
public class CandidatosController {

    @Autowired
    private CandidatosServices candidatosServices;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handle(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append(" " + violation.getMessage()));
            errorMessage = builder.toString();
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public Page<CandidatosDto> lista(
            @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        return candidatosServices.listarTodos(paginacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<List<CandidatosForm>> cadastrar(@RequestBody List<@Valid CandidatosForm> form) {
        candidatosServices.cadastrar(form);
        return ResponseEntity.ok().body(form);
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

    @GetMapping("/quantidadeReceptores")
    public ResponseEntity<List<PossiveisDoadoresDto>> quantidadeReceptores() {
        return ResponseEntity.ok().body(candidatosServices.quantidadeReceptores());
    }

}
