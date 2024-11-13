package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Parcelado;
import com.cesarschool.ecosunn.mapper.ParceladoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParceladoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParceladoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarParcelado(Parcelado parcelado) {
        String sql = "INSERT INTO Parcelado (qdt_parcelas, valor_parcela, fk_Forma_Pagamento_ID_Pagamento) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, parcelado.getQtdParcelas(), parcelado.getValorParcela(), parcelado.getIdPagamento());
    }

    public Parcelado buscarParceladoPorId(int id) {
        String sql = "SELECT * FROM Parcelado WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        return jdbcTemplate.queryForObject(sql, new ParceladoRowMapper(), id);
    }

    public List<Parcelado> listarPagamentosParcelados() {
        String sql = "SELECT * FROM Parcelado";
        return jdbcTemplate.query(sql, new ParceladoRowMapper());
    }

    public void atualizarParcelado(Parcelado parcelado) {
        String sql = "UPDATE Parcelado SET qdt_parcelas = ?, valor_parcela = ? WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        jdbcTemplate.update(sql, parcelado.getQtdParcelas(), parcelado.getValorParcela(), parcelado.getIdPagamento());
    }

    public void excluirParcelado(int id) {
        String sql = "DELETE FROM Parcelado WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        jdbcTemplate.update(sql, id);
    }
}

