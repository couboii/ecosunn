package com.cesarschool.ecosunn.model;

public class Tecnico {
    private Integer idTecnico;
    private String nome;
    private String telefone;
    private String email;
    private Integer instalacaoId; // Referência para fk_Instalacao_ID_instalacao

    // Getters e Setters
    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getInstalacaoId() {
        return instalacaoId;
    }

    public void setInstalacaoId(Integer instalacaoId) {
        this.instalacaoId = instalacaoId;
    }
}
