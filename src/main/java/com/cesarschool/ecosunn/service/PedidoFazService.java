package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.PedidoFazDAO;
import com.cesarschool.ecosunn.model.PedidoFaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoFazService {

    private final PedidoFazDAO pedidoFazDAO;

    @Autowired
    public PedidoFazService(PedidoFazDAO pedidoFazDAO) {
        this.pedidoFazDAO = pedidoFazDAO;
    }

    public void addPedido(PedidoFaz pedido) {
        if (pedido == null || pedido.getIdPagamento() == null || pedido.getIdInstalacao() == null) {
            throw new IllegalArgumentException("Dados do pedido inválidos");
        }
        pedidoFazDAO.adicionarPedido(pedido);
    }

    public List<PedidoFaz> getAllPedidos() {
        return pedidoFazDAO.listarPedidos();
    }

    public PedidoFaz getPedidoById(int idPagamento, int idInstalacao) {
        return pedidoFazDAO.buscarPedidoPorId(idPagamento, idInstalacao);
    }

    public void deletePedido(int idPagamento, int idInstalacao) {
        pedidoFazDAO.excluirPedido(idPagamento, idInstalacao);
    }
}

