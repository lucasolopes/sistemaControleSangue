package br.com.wk.processo.seletivo.sangue.controller.dto;

public class PossiveisDoadoresDto {
    private String tipoSanguineo;
    private Integer quantidade;

    public PossiveisDoadoresDto(String tipoSanguineo, Integer quantidade) {
        this.tipoSanguineo = tipoSanguineo;
        this.quantidade = quantidade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
