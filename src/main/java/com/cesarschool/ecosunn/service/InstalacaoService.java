package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.InstalacaoDAO;
import com.cesarschool.ecosunn.model.Instalacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InstalacaoService {

    private final InstalacaoDAO instalacaoDAO;

    @Autowired
    public InstalacaoService(InstalacaoDAO instalacaoDAO) {
        this.instalacaoDAO = instalacaoDAO;
    }

    // Adicionar uma nova instalação
    public void addInstalacao(Instalacao instalacao) {
        if (instalacao == null || instalacao.getComentarioServico() == null || instalacao.getDataInstalacao() == null) {
            throw new IllegalArgumentException("Dados da instalação inválidos");
        }
        instalacaoDAO.adicionarInstalacao(instalacao);
    }

    // Buscar instalação pelo ID
    public Instalacao getInstalacaoById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        return instalacaoDAO.buscarInstalacaoPorId(id);
    }

    // Listar todas as instalações
    public List<Instalacao> getAllInstalacoes() {
        return instalacaoDAO.listarInstalacoes();
    }

    // Atualizar uma instalação
    public void updateInstalacao(Instalacao instalacao) {
        if (instalacao == null || instalacao.getComentarioServico() == null || instalacao.getDataInstalacao() == null || instalacao.getIdInstalacao() == null) {
            throw new IllegalArgumentException("Dados da instalação inválidos");
        }
        instalacaoDAO.atualizarInstalacao(instalacao);
    }

    // Excluir uma instalação
    public void deleteInstalacao(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        instalacaoDAO.excluirInstalacao(id);
    }
    // Método para contar técnicos por instalação
    public int contarTecnicosPorInstalacao(int idInstalacao) {
        if (idInstalacao <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        return instalacaoDAO.contarTecnicosPorInstalacao(idInstalacao);
    }
    public List<Map<String, Object>> contarTecnicosTodasInstalacoes() {
        return instalacaoDAO.contarTecnicosTodasInstalacoes();
    }

}
