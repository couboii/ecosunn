package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setEmail(rs.getString("email"));
        cliente.setNome(rs.getString("nome"));
        cliente.setRua(rs.getString("rua"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setCidade(rs.getString("cidade"));
        cliente.setCep(rs.getInt("CEP"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setCpf(rs.getString("CPF"));
        cliente.setCnpj(rs.getString("CNPJ"));
        cliente.setTipo(rs.getInt("Clientes_TIPO"));
        return cliente;
    }
}

