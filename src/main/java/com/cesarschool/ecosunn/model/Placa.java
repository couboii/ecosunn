package com.cesarschool.ecosunn.model;

public class Placa {
    private Integer idPlaca;
    private String potenciaPlaca;
    private Integer qtdPlacas;
    private String prazoGarantia;
    private Integer instalacaoId;
    private String fornecedorCnpj;

    // Getters e Setters
    public Integer getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(Integer idPlaca) {
        this.idPlaca = idPlaca;
    }

    public String getPotenciaPlaca() {
        return potenciaPlaca;
    }

    public void setPotenciaPlaca(String potenciaPlaca) {
        this.potenciaPlaca = potenciaPlaca;
    }

    public Integer getQtdPlacas() {
        return qtdPlacas;
    }

    public void setQtdPlacas(Integer qtdPlacas) {
        this.qtdPlacas = qtdPlacas;
    }

    public String getPrazoGarantia() {
        return prazoGarantia;
    }

    public void setPrazoGarantia(String prazoGarantia) {
        this.prazoGarantia = prazoGarantia;
    }

    public Integer getInstalacaoId() {
        return instalacaoId;
    }

    public void setInstalacaoId(Integer instalacaoId) {
        this.instalacaoId = instalacaoId;
    }

    public String getFornecedorCnpj() {
        return fornecedorCnpj;
    }

    public void setFornecedorCnpj(String fornecedorCnpj) {
        this.fornecedorCnpj = fornecedorCnpj;
    }
}

