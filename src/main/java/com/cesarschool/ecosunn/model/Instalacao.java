package com.cesarschool.ecosunn.model;

public class Instalacao {
    private Integer idInstalacao;
    private String comentarioServico;
    private String dataInstalacao;

    // Getters e Setters
    public Integer getIdInstalacao() {
        return idInstalacao;
    }

    public void setIdInstalacao(Integer idInstalacao) {
        this.idInstalacao = idInstalacao;
    }

    public String getComentarioServico() {
        return comentarioServico;
    }

    public void setComentarioServico(String comentarioServico) {
        this.comentarioServico = comentarioServico;
    }

    public String getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(String dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }
}

