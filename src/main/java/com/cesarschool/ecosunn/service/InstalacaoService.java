package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.InstalacaoDAO;
import com.cesarschool.ecosunn.model.Instalacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class InstalacaoService {

    private static final Logger LOGGER = Logger.getLogger(InstalacaoService.class.getName());
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
        LOGGER.info("Adicionando nova instalação: " + instalacao);
        instalacaoDAO.adicionarInstalacao(instalacao);
    }

    // Buscar instalação pelo ID
    public Instalacao getInstalacaoById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        LOGGER.info("Buscando instalação com ID: " + id);
        return Optional.ofNullable(instalacaoDAO.buscarInstalacaoPorId(id))
                .orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada para o ID: " + id));
    }

    // Listar todas as instalações
    public List<Instalacao> getAllInstalacoes() {
        LOGGER.info("Listando todas as instalações.");
        return instalacaoDAO.listarInstalacoes();
    }

    // Atualizar uma instalação
    public void updateInstalacao(Instalacao instalacao) {
        if (instalacao == null || instalacao.getComentarioServico() == null
                || instalacao.getDataInstalacao() == null || instalacao.getIdInstalacao() == null) {
            throw new IllegalArgumentException("Dados da instalação inválidos");
        }
        LOGGER.info("Atualizando instalação com ID: " + instalacao.getIdInstalacao());
        instalacaoDAO.atualizarInstalacao(instalacao);
    }

    // Excluir uma instalação
    public void deleteInstalacao(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        LOGGER.info("Excluindo instalação com ID: " + id);
        instalacaoDAO.excluirInstalacao(id);
    }

    // Método para contar técnicos por instalação
    public int contarTecnicosPorInstalacao(int idInstalacao) {
        if (idInstalacao <= 0) {
            throw new IllegalArgumentException("ID de instalação inválido");
        }
        LOGGER.info("Contando técnicos para instalação com ID: " + idInstalacao);
        return instalacaoDAO.contarTecnicosPorInstalacao(idInstalacao);
    }

    // Método para contar técnicos de todas as instalações
    public List<Map<String, Object>> contarTecnicosTodasInstalacoes() {
        LOGGER.info("Contando técnicos para todas as instalações.");
        List<Map<String, Object>> counts = instalacaoDAO.contarTecnicosTodasInstalacoes();
        LOGGER.info("Dados retornados: " + counts);
        return counts;
    }
}