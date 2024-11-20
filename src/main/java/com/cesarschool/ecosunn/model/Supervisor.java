package com.cesarschool.ecosunn.model;

public class Supervisor {
    private Integer supervisorId; // ID do supervisor
    private Integer tecnicoId;    // ID do supervisionado
    private String nomeSupervisor;
    private String nomeSupervisionado;

    // Getters e Setters
    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Integer getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public String getNomeSupervisor() {
        return nomeSupervisor;
    }

    public void setNomeSupervisor(String nomeSupervisor) {
        this.nomeSupervisor = nomeSupervisor;
    }

    public String getNomeSupervisionado() {
        return nomeSupervisionado;
    }

    public void setNomeSupervisionado(String nomeSupervisionado) {
        this.nomeSupervisionado = nomeSupervisionado;
    }
}
