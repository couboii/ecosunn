package com.cesarschool.ecosunn.model;


public class Cliente {
    private String email;
    private String nome;
    private String rua;
    private String bairro;
    private String cidade;
    private int cep;
    private String telefone;
    private String cpf;
    private String cnpj;
    private int tipo;

    // Construtor padrão
    public Cliente() {}

    // Construtor com todos os parâmetros
    public Cliente(String email, String nome, String rua, String bairro, String cidade, int cep, String telefone, String cpf, String cnpj, int tipo) {
        this.email = email;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // Método toString para facilitar a exibição das informações do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep=" + cep +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
