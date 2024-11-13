package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.FormaPagamentoDAO;
import com.cesarschool.ecosunn.model.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoDAO formaPagamentoDAO;

    @Autowired
    public FormaPagamentoService(FormaPagamentoDAO formaPagamentoDAO) {
        this.formaPagamentoDAO = formaPagamentoDAO;
    }

    public void addFormaPagamento(FormaPagamento formaPagamento) {
        if (formaPagamento == null || formaPagamento.getValorTotal() == null || formaPagamento.getDataEmissao() == null) {
            throw new IllegalArgumentException("Dados da forma de pagamento inválidos");
        }
        formaPagamentoDAO.adicionarFormaPagamento(formaPagamento);
    }

    public FormaPagamento getFormaPagamentoById(int id) {
        return formaPagamentoDAO.buscarFormaPagamentoPorId(id);
    }

    public List<FormaPagamento> getAllFormasPagamento() {
        return formaPagamentoDAO.listarFormasPagamento();
    }

    public void updateFormaPagamento(FormaPagamento formaPagamento) {
        formaPagamentoDAO.atualizarFormaPagamento(formaPagamento);
    }

    public void deleteFormaPagamento(int id) {
        formaPagamentoDAO.excluirFormaPagamento(id);
    }
}

