package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.PedidoFaz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoFazRowMapper implements RowMapper<PedidoFaz> {

    @Override
    public PedidoFaz mapRow(ResultSet rs, int rowNum) throws SQLException {
        PedidoFaz pedido = new PedidoFaz();
        pedido.setIdPagamento(rs.getInt("fk_Forma_Pagamento_ID_Pagamento"));
        pedido.setIdInstalacao(rs.getInt("fk_Instalacao_ID_instalacao"));
        pedido.setCpfCliente(rs.getString("fk_Clientes_CPF"));
        pedido.setCnpjCliente(rs.getString("fk_Clientes_CNPJ"));
        return pedido;
    }
}
