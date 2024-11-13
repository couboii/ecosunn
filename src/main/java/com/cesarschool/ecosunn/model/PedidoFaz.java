package com.cesarschool.ecosunn.model;

public class PedidoFaz {
    private Integer idPagamento;
    private Integer idInstalacao;
    private String cpfCliente;
    private String cnpjCliente;

    // Getters e Setters
    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdInstalacao() {
        return idInstalacao;
    }

    public void setIdInstalacao(Integer idInstalacao) {
        this.idInstalacao = idInstalacao;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }
}
