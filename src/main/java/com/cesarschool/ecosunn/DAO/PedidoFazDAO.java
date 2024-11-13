package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.PedidoFaz;
import com.cesarschool.ecosunn.mapper.PedidoFazRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoFazDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoFazDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarPedido(PedidoFaz pedido) {
        String sql = "INSERT INTO pedido_faz (fk_Forma_Pagamento_ID_Pagamento, fk_Instalacao_ID_instalacao, fk_Clientes_CPF, fk_Clientes_CNPJ) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pedido.getIdPagamento(), pedido.getIdInstalacao(), pedido.getCpfCliente(), pedido.getCnpjCliente());
    }

    public List<PedidoFaz> listarPedidos() {
        String sql = "SELECT * FROM pedido_faz";
        return jdbcTemplate.query(sql, new PedidoFazRowMapper());
    }

    public PedidoFaz buscarPedidoPorId(int idPagamento, int idInstalacao) {
        String sql = "SELECT * FROM pedido_faz WHERE fk_Forma_Pagamento_ID_Pagamento = ? AND fk_Instalacao_ID_instalacao = ?";
        return jdbcTemplate.queryForObject(sql, new PedidoFazRowMapper(), idPagamento, idInstalacao);
    }

    public void excluirPedido(int idPagamento, int idInstalacao) {
        String sql = "DELETE FROM pedido_faz WHERE fk_Forma_Pagamento_ID_Pagamento = ? AND fk_Instalacao_ID_instalacao = ?";
        jdbcTemplate.update(sql, idPagamento, idInstalacao);
    }
}
