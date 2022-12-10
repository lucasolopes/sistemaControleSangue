package br.com.wk.processo.seletivo.sangue.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Candidatos;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

    long countByEstado(String estado);

    @Query(value = "Select count(candidatos.estado) as quantidade,candidatos.estado from candidatos group by candidatos.estado having count(candidatos.estado) > 1 order by count(candidatos.estado) desc", nativeQuery = true)
    List<CandidatosPorEstado> TodosCandidatosPorEstado();

    // @Query(value = "Select candidatos.peso, candidatos.altura,
    // candidatos.data_nasc from candidatos", nativeQuery = true)
    List<BuscarDadosCandidatos> findAllBy();

    Long countBySexo(String sexo);

    @Query(value = "Select count(tipo_Sanguineo) as quantidade, sum(idade) as somaIdade ,tipo_Sanguineo as tipoSanguineo, idade,peso from candidatos group by tipo_Sanguineo", nativeQuery = true)
    List<QuantidateTipoSanquineo> listaQuantidadeTipoSanguineo();

    @Query(value = "Select count(tipo_Sanguineo) as quantidade, sum(idade) as somaIdade ,tipo_Sanguineo as tipoSanguineo, idade,peso from candidatos group by tipo_Sanguineo", nativeQuery = true)
    QuantidateTipoSanquineo quantidadeTipoSanguineo();

}
