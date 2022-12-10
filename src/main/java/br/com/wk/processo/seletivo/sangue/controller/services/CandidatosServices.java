package br.com.wk.processo.seletivo.sangue.controller.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.wk.processo.seletivo.sangue.controller.dto.CandidatosDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.ImcObesidadePorSexoDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.ImcPorFaixaIdadeDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.PossiveisDoadoresDto;
import br.com.wk.processo.seletivo.sangue.controller.dto.QuantidateTipoSanquineoDto;
import br.com.wk.processo.seletivo.sangue.controller.form.CandidatosForm;
import br.com.wk.processo.seletivo.sangue.controller.modelo.Candidatos;
import br.com.wk.processo.seletivo.sangue.controller.repository.BuscarDadosCandidatos;
import br.com.wk.processo.seletivo.sangue.controller.repository.CandidatosPorEstado;
import br.com.wk.processo.seletivo.sangue.controller.repository.CandidatosRepository;
import br.com.wk.processo.seletivo.sangue.controller.repository.QuantidateTipoSanquineo;

@Service
public class CandidatosServices {

    @Autowired
    private CandidatosRepository candidatosRepository;

    public Page<CandidatosDto> listarTodos(Pageable paginacao) {
        Page<Candidatos> candidatos = candidatosRepository.findAll(paginacao);
        return CandidatosDto.converter(candidatos);
    }

    public void cadastrar(@Valid ArrayList<CandidatosForm> form) {
        form.forEach(c -> {
            Candidatos candidatos = c.converter();
            candidatosRepository.save(candidatos);
        });
    }

    public List<CandidatosPorEstado> quantidadeCandidatosPorEstado() {
        return candidatosRepository.TodosCandidatosPorEstado();
    }

    public List<BuscarDadosCandidatos> ImcMedioPorIdade() {
        return candidatosRepository.findAllBy();
    }

    private Float calcularImc(int peso, Float altura) {
        return peso / (altura * altura);
    }

    public List<ImcPorFaixaIdadeDto> calcularImcPorIdade(List<BuscarDadosCandidatos> dadosImc) {
        List<ImcPorFaixaIdadeDto> listaImcFaixaIdade = new ArrayList<>();
        Integer idadeMinima = 0;
        Integer idadeMaxima = 10;

        String faixaEtaria = idadeMinima.toString() + " a " + idadeMaxima.toString();
        while (idadeMaxima <= 100) {
            Float imcTotal = 0f;
            int quantidade = 0;

            for (BuscarDadosCandidatos dados : dadosImc) {
                if (dados.getIdade() >= idadeMinima && dados.getIdade() <= idadeMaxima) {
                    Float imc = calcularImc(dados.getPeso(), dados.getAltura());
                    imcTotal += imc;
                    quantidade++;
                }
            }

            Float media = imcTotal / quantidade;
            listaImcFaixaIdade.add(new ImcPorFaixaIdadeDto(faixaEtaria, media));

            idadeMinima = idadeMaxima + 1;
            idadeMaxima += 10;
            faixaEtaria = idadeMinima.toString() + " a " + idadeMaxima.toString();
        }
        return listaImcFaixaIdade;
    }

    public List<ImcObesidadePorSexoDto> percentualObesos(List<BuscarDadosCandidatos> dadosImc) {
        Long quantidadeHomens = candidatosRepository.countBySexo("Masculino");
        Long quantidadeMulheres = candidatosRepository.countBySexo("Feminino");
        float quantidadeHomensObesos = 0;
        float quantidadeMulheresObesas = 0f;
        List<ImcObesidadePorSexoDto> listaImcObesidade = new ArrayList<>();

        for (BuscarDadosCandidatos dados : dadosImc) {
            Float imc = calcularImc(dados.getPeso(), dados.getAltura());
            if (imc > 30) {

                if (dados.getSexo().contentEquals("Masculino")) {
                    quantidadeHomensObesos++;
                } else {
                    quantidadeMulheresObesas++;
                }
            }

        }
        Float percentualHomensObesos = (quantidadeHomensObesos * 100) / quantidadeHomens;
        Float percentualMulheresObesas = (quantidadeMulheresObesas * 100) / quantidadeMulheres;
        listaImcObesidade.add(new ImcObesidadePorSexoDto("Masculino", percentualHomensObesos));
        listaImcObesidade.add(new ImcObesidadePorSexoDto("Feminino", percentualMulheresObesas));
        return listaImcObesidade;
    }

    public List<QuantidateTipoSanquineoDto> tipoSanguineo() {

        List<QuantidateTipoSanquineoDto> quantidateTipoSanquineo = new ArrayList<>();

        List<QuantidateTipoSanquineo> dadosTipoSanguineo = candidatosRepository.listaQuantidadeTipoSanguineo();

        for (QuantidateTipoSanquineo dados : dadosTipoSanguineo) {
            Float SomaIdade = dados.getSomaIdade();
            Long quantidade = dados.getQuantidade();
            Float mediaIdade = SomaIdade / quantidade;
            quantidateTipoSanquineo.add(new QuantidateTipoSanquineoDto(dados.getTipoSanguineo(), mediaIdade));
        }
        return quantidateTipoSanquineo;
    }

    public List<PossiveisDoadoresDto> possiveisReceptores() {
        List<PossiveisDoadoresDto> possiveisReceptores = new ArrayList<>();
        List<QuantidateTipoSanquineo> dadosTipoSanguineo = candidatosRepository.listaQuantidadeTipoSanguineo();
        Long quantidadeDoadores = 0l;

        for (QuantidateTipoSanquineo dados : dadosTipoSanguineo) {
            if (dados.getTipoSanguineo().contentEquals("A+") || dados.getTipoSanguineo().contentEquals("B+")
                    || dados.getTipoSanguineo().contentEquals("AB-")) {
                quantidadeDoadores = dados.getQuantidade() * 4;
                possiveisReceptores.add(new PossiveisDoadoresDto(dados.getTipoSanguineo(), quantidadeDoadores));
            }
            if (dados.getTipoSanguineo().contentEquals("A-") || dados.getTipoSanguineo().contentEquals("B-")
                    || dados.getTipoSanguineo().contentEquals("O+")) {
                quantidadeDoadores = dados.getQuantidade() * 2;
                possiveisReceptores.add(new PossiveisDoadoresDto(dados.getTipoSanguineo(), quantidadeDoadores));
            }
            if (dados.getTipoSanguineo().contentEquals("AB+")) {
                quantidadeDoadores = dados.getQuantidade() * 8;
                possiveisReceptores.add(new PossiveisDoadoresDto(dados.getTipoSanguineo(), quantidadeDoadores));
            }
            if (dados.getTipoSanguineo().contentEquals("O-")) {
                quantidadeDoadores = dados.getQuantidade();
                possiveisReceptores.add(new PossiveisDoadoresDto(dados.getTipoSanguineo(), quantidadeDoadores));
            }
        }

        return possiveisReceptores;
    }
}
