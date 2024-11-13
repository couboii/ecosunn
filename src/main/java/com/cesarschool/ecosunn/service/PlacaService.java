package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.PlacaDAO;
import com.cesarschool.ecosunn.model.Placa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacaService {

    private final PlacaDAO placaDAO;

    @Autowired
    public PlacaService(PlacaDAO placaDAO) {
        this.placaDAO = placaDAO;
    }

    public void addPlaca(Placa placa) {
        if (placa == null || placa.getFornecedorCnpj() == null || placa.getPrazoGarantia() == null) {
            throw new IllegalArgumentException("Dados da placa inválidos");
        }
        placaDAO.adicionarPlaca(placa);
    }

    public Placa getPlacaById(int id) {
        return placaDAO.buscarPlacaPorId(id);
    }

    public List<Placa> getAllPlacas() {
        return placaDAO.listarPlacas();
    }

    public void updatePlaca(Placa placa) {
        placaDAO.atualizarPlaca(placa);
    }

    public void deletePlaca(int id) {
        placaDAO.excluirPlaca(id);
    }
}

