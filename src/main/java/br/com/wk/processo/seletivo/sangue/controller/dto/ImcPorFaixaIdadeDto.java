package br.com.wk.processo.seletivo.sangue.controller.dto;

public class ImcPorFaixaIdadeDto {

    private String faixaEtaria;
    private Float imcMedio;

    public Float getImcMedio() {
        return imcMedio;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public ImcPorFaixaIdadeDto(String faixaEtaria, Float imcMedio) {
        this.faixaEtaria = faixaEtaria;
        this.imcMedio = imcMedio;
    }

}
