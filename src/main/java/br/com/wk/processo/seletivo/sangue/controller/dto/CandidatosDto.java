package br.com.wk.processo.seletivo.sangue.controller.dto;

import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.wk.processo.seletivo.sangue.controller.modelo.Candidatos;

public class CandidatosDto {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNasc;
    private String sexo;
    private String mae;
    private String pai;
    private String email;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefoneFixo;
    private String celular;
    private Float altura;
    private int peso;
    private String tipoSanguineo;
    private int idade;

    public CandidatosDto(Candidatos candidatos) {
        this.id = candidatos.getId();
        this.nome = candidatos.getNome();
        this.cpf = candidatos.getCpf();
        this.rg = candidatos.getCpf();
        this.dataNasc = candidatos.getDataNasc();
        this.sexo = candidatos.getSexo();
        this.mae = candidatos.getMae();
        this.pai = candidatos.getPai();
        this.email = candidatos.getEmail();
        this.cep = candidatos.getCep();
        this.endereco = candidatos.getEndereco();
        this.numero = candidatos.getNumero();
        this.bairro = candidatos.getBairro();
        this.cidade = candidatos.getCidade();
        this.estado = candidatos.getEstado();
        this.telefoneFixo = candidatos.getTelefoneFixo();
        this.celular = candidatos.getCelular();
        this.altura = candidatos.getAltura();
        this.peso = candidatos.getPeso();
        this.tipoSanguineo = candidatos.getTipoSanguineo();
        this.idade = candidatos.getIdade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public String getMae() {
        return mae;
    }

    public String getPai() {
        return pai;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public Float getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public int getIdade() {
        return idade;
    }

    public static Page<CandidatosDto> converter(Page<Candidatos> listaCandidatos) {
        return listaCandidatos.map(CandidatosDto::new);
    }
}
