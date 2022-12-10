package br.com.wk.processo.seletivo.sangue.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Candidatos;

public class CandidatosForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @NotBlank
    private String data_nasc;
    @NotBlank
    private String sexo;
    @NotBlank
    private String mae;
    @NotBlank
    private String pai;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    @NotBlank
    private String endereco;
    @NotNull
    private int numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String telefone_fixo;
    @NotBlank
    private String celular;
    @NotNull
    private Float altura;
    @NotNull
    private int peso;
    @NotBlank
    private String tipo_sanguineo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    private Date conveterParaData(String string) {
        Date dataForamatada = new Date();
        try {
            dataForamatada = new SimpleDateFormat("dd/mm/yyyy").parse(string);
            return dataForamatada;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataForamatada;
    }

    private int calcularIdade(String string) {
        Date dataFormatada = conveterParaData(string);
        Calendar calendarDataAtual = Calendar.getInstance();
        Calendar calendarDataNascimento = Calendar.getInstance();
        calendarDataAtual.setTime(new Date());
        calendarDataNascimento.setTime(dataFormatada);
        return calendarDataAtual.get(Calendar.YEAR) - calendarDataNascimento.get(Calendar.YEAR);
    }

    public Candidatos converter() {
        Date dataForamatada = conveterParaData(data_nasc);
        int idade = calcularIdade(data_nasc);
        return new Candidatos(nome, cpf, rg, dataForamatada, sexo, mae, pai, email, cep, endereco, numero, bairro,
                cidade,
                estado, telefone_fixo, celular, altura, peso, tipo_sanguineo, idade);
    }
}
