package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.ParceladoDAO;
import com.cesarschool.ecosunn.model.Parcelado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParceladoService {

    private final ParceladoDAO parceladoDAO;

    @Autowired
    public ParceladoService(ParceladoDAO parceladoDAO) {
        this.parceladoDAO = parceladoDAO;
    }

    public void addParcelado(Parcelado parcelado) {
        if (parcelado == null || parcelado.getIdPagamento() == null || parcelado.getQtdParcelas() == null) {
            throw new IllegalArgumentException("Dados do pagamento parcelado inválidos");
        }
        parceladoDAO.adicionarParcelado(parcelado);
    }

    public Parcelado getParceladoById(int id) {
        return parceladoDAO.buscarParceladoPorId(id);
    }

    public List<Parcelado> getAllPagamentosParcelados() {
        return parceladoDAO.listarPagamentosParcelados();
    }

    public void updateParcelado(Parcelado parcelado) {
        parceladoDAO.atualizarParcelado(parcelado);
    }

    public void deleteParcelado(int id) {
        parceladoDAO.excluirParcelado(id);
    }
}

