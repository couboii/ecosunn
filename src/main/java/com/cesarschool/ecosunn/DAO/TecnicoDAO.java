package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Tecnico;
import com.cesarschool.ecosunn.mapper.TecnicoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TecnicoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TecnicoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para adicionar um novo técnico
    public void adicionarTecnico(Tecnico tecnico) {
        String sql = "INSERT INTO Tecnico (Nome, Telefone, Email, ID_Tecnico, fk_Instalacao_ID_instalacao) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tecnico.getNome(), tecnico.getTelefone(), tecnico.getEmail(), tecnico.getIdTecnico(), tecnico.getInstalacaoId());
    }

    // Método para buscar um técnico pelo ID
    public Tecnico buscarTecnicoPorId(int id) {
        String sql = "SELECT * FROM Tecnico WHERE ID_Tecnico = ?";
        return jdbcTemplate.queryForObject(sql, new TecnicoRowMapper(), id);
    }

    // Método para listar todos os técnicos
    public List<Tecnico> listarTecnicos() {
        String sql = "SELECT * FROM Tecnico";
        return jdbcTemplate.query(sql, new TecnicoRowMapper());
    }

    // Método para atualizar um técnico
    public void atualizarTecnico(Tecnico tecnico) {
        String sql = "UPDATE Tecnico SET Nome = ?, Telefone = ?, Email = ?, fk_Instalacao_ID_instalacao = ? WHERE ID_Tecnico = ?";
        jdbcTemplate.update(sql, tecnico.getNome(), tecnico.getTelefone(), tecnico.getEmail(), tecnico.getInstalacaoId(), tecnico.getIdTecnico());
    }

    // Método para excluir um técnico
    public void excluirTecnico(int id) {
        String sql = "DELETE FROM Tecnico WHERE ID_Tecnico = ?";
        jdbcTemplate.update(sql, id);
    }
}

