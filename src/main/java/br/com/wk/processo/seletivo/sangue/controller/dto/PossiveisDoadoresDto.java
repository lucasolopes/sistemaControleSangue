package br.com.wk.processo.seletivo.sangue.controller.dto;

public class PossiveisDoadoresDto {
    private String tipoSanguineo;
    private Long quantidade;

    public PossiveisDoadoresDto(String tipoSanguineo, Long quantidade) {
        this.tipoSanguineo = tipoSanguineo;
        this.quantidade = quantidade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

}
