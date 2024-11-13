package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Placa;
import com.cesarschool.ecosunn.mapper.PlacaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlacaDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlacaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarPlaca(Placa placa) {
        String sql = "INSERT INTO Placa (ID_placa, Potencia_placa, qtd_placas, prazo_garantia, fk_Instalacao_ID_instalacao, fk_Fornecedor_CNPJ) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, placa.getIdPlaca(), placa.getPotenciaPlaca(), placa.getQtdPlacas(),
                placa.getPrazoGarantia(), placa.getInstalacaoId(), placa.getFornecedorCnpj());
    }

    public Placa buscarPlacaPorId(int id) {
        String sql = "SELECT * FROM Placa WHERE ID_placa = ?";
        return jdbcTemplate.queryForObject(sql, new PlacaRowMapper(), id);
    }

    public List<Placa> listarPlacas() {
        String sql = "SELECT * FROM Placa";
        return jdbcTemplate.query(sql, new PlacaRowMapper());
    }

    public void atualizarPlaca(Placa placa) {
        String sql = "UPDATE Placa SET Potencia_placa = ?, qtd_placas = ?, prazo_garantia = ?, fk_Instalacao_ID_instalacao = ?, fk_Fornecedor_CNPJ = ? WHERE ID_placa = ?";
        jdbcTemplate.update(sql, placa.getPotenciaPlaca(), placa.getQtdPlacas(), placa.getPrazoGarantia(),
                placa.getInstalacaoId(), placa.getFornecedorCnpj(), placa.getIdPlaca());
    }

    public void excluirPlaca(int id) {
        String sql = "DELETE FROM Placa WHERE ID_placa = ?";
        jdbcTemplate.update(sql, id);
    }
}

