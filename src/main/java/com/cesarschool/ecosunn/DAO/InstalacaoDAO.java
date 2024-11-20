package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Instalacao;
import com.cesarschool.ecosunn.mapper.InstalacaoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InstalacaoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InstalacaoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para adicionar uma nova instalação
    public void adicionarInstalacao(Instalacao instalacao) {
        String sql = "INSERT INTO Instalacao (ID_instalacao, comentario_servico, data_instalacao) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, instalacao.getIdInstalacao(), instalacao.getComentarioServico(), instalacao.getDataInstalacao());
    }

    // Método para buscar uma instalação pelo ID
    public Instalacao buscarInstalacaoPorId(int id) {
        String sql = "SELECT * FROM Instalacao WHERE ID_instalacao = ?";
        return jdbcTemplate.queryForObject(sql, new InstalacaoRowMapper(), id);
    }

    // Método para listar todas as instalações
    public List<Instalacao> listarInstalacoes() {
        String sql = "SELECT * FROM Instalacao";
        return jdbcTemplate.query(sql, new InstalacaoRowMapper());
    }

    // Método para atualizar uma instalação
    public void atualizarInstalacao(Instalacao instalacao) {
        String sql = "UPDATE Instalacao SET comentario_servico = ?, data_instalacao = ? WHERE ID_instalacao = ?";
        jdbcTemplate.update(sql, instalacao.getComentarioServico(), instalacao.getDataInstalacao(), instalacao.getIdInstalacao());
    }

    // Método para excluir uma instalação
    public void excluirInstalacao(int id) {
        String sql = "DELETE FROM Instalacao WHERE ID_instalacao = ?";
        jdbcTemplate.update(sql, id);
    }
    // Método para contar técnicos associados a uma instalação
    public int contarTecnicosPorInstalacao(int idInstalacao) {
        String sql = "SELECT ContarTecnicosPorInstalacao(?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, idInstalacao);
    }
    public List<Map<String, Object>> contarTecnicosTodasInstalacoes() {
        String sql = "SELECT ID_instalacao, ContarTecnicosPorInstalacao(ID_instalacao) AS count_tecnicos FROM Instalacao";
        return jdbcTemplate.queryForList(sql);
    }


}
