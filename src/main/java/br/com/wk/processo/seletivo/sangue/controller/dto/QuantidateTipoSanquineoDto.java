package br.com.wk.processo.seletivo.sangue.controller.dto;

public class QuantidateTipoSanquineoDto {
    private String tipoSanguineo;
    private Float mediaIdade;

    public QuantidateTipoSanquineoDto(String tipoSanguineo, Float mediaIdade) {
        this.tipoSanguineo = tipoSanguineo;
        this.mediaIdade = mediaIdade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public Float getMediaIdade() {
        return mediaIdade;
    }

}
