package br.com.wk.processo.seletivo.sangue.controller.dto;

public class TiposSanguineos {

    public static String[] APositivoDoadores() {
        String[] anticorpos = { "A+", "A-", "O+", "O-" };
        return anticorpos;
    }

    public static String[] BPositivoDoadores() {
        String[] anticorpos = { "B+", "B-", "O+", "O-" };
        return anticorpos;
    }

    public static String[] ABPositivoDoadores() {
        String[] anticorpos = { "A+", "A-", "O+", "O-", "AB+", "AB-", "B+", "B-" };
        return anticorpos;
    }

    public static String[] OPositivoDoadores() {
        String[] anticorpos = { "O+", "O-" };
        return anticorpos;
    }

    public static String[] ANegativoDoadores() {
        String[] anticorpos = { "A-", "O-" };
        return anticorpos;
    }

    public static String[] BNegativoDoadores() {
        String[] anticorpos = { "B-", "O-" };
        return anticorpos;
    }

    public static String[] ABNegativoDoadores() {
        String[] anticorpos = { "A-", "B-", "O-", "AB-" };
        return anticorpos;
    }

    public static String[] ONegativoDoadores() {
        String[] anticorpos = { "O-" };
        return anticorpos;
    }

    public static String[] todosTipo() {
        String[] tipos = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        return tipos;
    }

}
