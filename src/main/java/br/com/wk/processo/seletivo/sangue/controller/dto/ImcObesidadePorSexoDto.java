package br.com.wk.processo.seletivo.sangue.controller.dto;

public class ImcObesidadePorSexoDto {

    private String sexo;
    private Float percentual;

    public ImcObesidadePorSexoDto(String sexo, Float percentual) {
        this.sexo = sexo;
        this.percentual = percentual;
    }

    public String getSexo() {
        return sexo;
    }

    public Float getPercentual() {
        return percentual;
    }

}
