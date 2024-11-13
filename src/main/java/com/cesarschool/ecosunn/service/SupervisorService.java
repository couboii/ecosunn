package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.SupervisorDAO;
import com.cesarschool.ecosunn.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {

    private final SupervisorDAO supervisorDAO;

    @Autowired
    public SupervisorService(SupervisorDAO supervisorDAO) {
        this.supervisorDAO = supervisorDAO;
    }

    public void addSupervisor(Supervisor supervisor) {
        if (supervisor == null || supervisor.getTecnicoId() == null || supervisor.getSupervisorId() == null) {
            throw new IllegalArgumentException("Dados do supervisor inválidos");
        }
        supervisorDAO.adicionarSupervisor(supervisor);
    }

    public List<Supervisor> getAllSupervisores() {
        return supervisorDAO.listarSupervisores();
    }

    public void deleteSupervisor(int tecnicoId, int supervisorId) {
        supervisorDAO.excluirSupervisor(tecnicoId, supervisorId);
    }
}
