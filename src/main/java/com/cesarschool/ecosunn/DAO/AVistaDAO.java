package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.AVista;
import com.cesarschool.ecosunn.mapper.AVistaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AVistaDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AVistaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarAVista(AVista aVista) {
        String sql = "INSERT INTO A_vista (desconto, fk_Forma_Pagamento_ID_Pagamento) VALUES (?, ?)";
        jdbcTemplate.update(sql, aVista.getDesconto(), aVista.getIdPagamento());
    }

    public AVista buscarAVistaPorId(int id) {
        String sql = "SELECT * FROM A_vista WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        return jdbcTemplate.queryForObject(sql, new AVistaRowMapper(), id);
    }

    public List<AVista> listarPagamentosAVista() {
        String sql = "SELECT * FROM A_vista";
        return jdbcTemplate.query(sql, new AVistaRowMapper());
    }

    public void atualizarAVista(AVista aVista) {
        String sql = "UPDATE A_vista SET desconto = ? WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        jdbcTemplate.update(sql, aVista.getDesconto(), aVista.getIdPagamento());
    }

    public void excluirAVista(int id) {
        String sql = "DELETE FROM A_vista WHERE fk_Forma_Pagamento_ID_Pagamento = ?";
        jdbcTemplate.update(sql, id);
    }
}

