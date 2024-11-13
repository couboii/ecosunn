package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.AVistaDAO;
import com.cesarschool.ecosunn.model.AVista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AVistaService {

    private final AVistaDAO aVistaDAO;

    @Autowired
    public AVistaService(AVistaDAO aVistaDAO) {
        this.aVistaDAO = aVistaDAO;
    }

    public void addAVista(AVista aVista) {
        if (aVista == null || aVista.getIdPagamento() == null || aVista.getDesconto() == null) {
            throw new IllegalArgumentException("Dados do pagamento à vista inválidos");
        }
        aVistaDAO.adicionarAVista(aVista);
    }

    public AVista getAVistaById(int id) {
        return aVistaDAO.buscarAVistaPorId(id);
    }

    public List<AVista> getAllPagamentosAVista() {
        return aVistaDAO.listarPagamentosAVista();
    }

    public void updateAVista(AVista aVista) {
        aVistaDAO.atualizarAVista(aVista);
    }

    public void deleteAVista(int id) {
        aVistaDAO.excluirAVista(id);
    }
}
