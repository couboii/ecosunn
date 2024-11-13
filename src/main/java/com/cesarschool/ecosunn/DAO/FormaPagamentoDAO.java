package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.FormaPagamento;
import com.cesarschool.ecosunn.mapper.FormaPagamentoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormaPagamentoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FormaPagamentoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarFormaPagamento(FormaPagamento formaPagamento) {
        String sql = "INSERT INTO Forma_Pagamento (ID_Pagamento, valor_total, data_emissao) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, formaPagamento.getIdPagamento(), formaPagamento.getValorTotal(), formaPagamento.getDataEmissao());
    }

    public FormaPagamento buscarFormaPagamentoPorId(int id) {
        String sql = "SELECT * FROM Forma_Pagamento WHERE ID_Pagamento = ?";
        return jdbcTemplate.queryForObject(sql, new FormaPagamentoRowMapper(), id);
    }

    public List<FormaPagamento> listarFormasPagamento() {
        String sql = "SELECT * FROM Forma_Pagamento";
        return jdbcTemplate.query(sql, new FormaPagamentoRowMapper());
    }

    public void atualizarFormaPagamento(FormaPagamento formaPagamento) {
        String sql = "UPDATE Forma_Pagamento SET valor_total = ?, data_emissao = ? WHERE ID_Pagamento = ?";
        jdbcTemplate.update(sql, formaPagamento.getValorTotal(), formaPagamento.getDataEmissao(), formaPagamento.getIdPagamento());
    }

    public void excluirFormaPagamento(int id) {
        String sql = "DELETE FROM Forma_Pagamento WHERE ID_Pagamento = ?";
        jdbcTemplate.update(sql, id);
    }
}
