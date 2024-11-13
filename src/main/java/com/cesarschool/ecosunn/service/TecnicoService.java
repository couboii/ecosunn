package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.TecnicoDAO;
import com.cesarschool.ecosunn.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoDAO tecnicoDAO;

    @Autowired
    public TecnicoService(TecnicoDAO tecnicoDAO) {
        this.tecnicoDAO = tecnicoDAO;
    }

    public void addTecnico(Tecnico tecnico) {
        if (tecnico == null || tecnico.getNome() == null || tecnico.getEmail() == null) {
            throw new IllegalArgumentException("Dados do técnico inválidos");
        }
        tecnicoDAO.adicionarTecnico(tecnico);
    }

    public Tecnico getTecnicoById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do técnico inválido");
        }
        return tecnicoDAO.buscarTecnicoPorId(id);
    }

    public List<Tecnico> getAllTecnicos() {
        return tecnicoDAO.listarTecnicos();
    }

    public void updateTecnico(Tecnico tecnico) {
        if (tecnico == null || tecnico.getNome() == null || tecnico.getEmail() == null || tecnico.getIdTecnico() == null) {
            throw new IllegalArgumentException("Dados do técnico inválidos");
        }
        tecnicoDAO.atualizarTecnico(tecnico);
    }

    public void deleteTecnico(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do técnico inválido");
        }
        tecnicoDAO.excluirTecnico(id);
    }
}

