package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Fornecedor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorRowMapper implements RowMapper<Fornecedor> {

    @Override
    public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(rs.getString("CNPJ"));
        fornecedor.setNomeEmpresa(rs.getString("Nome_Empresa"));
        fornecedor.setTelefone(rs.getString("telefone"));
        fornecedor.setEmail(rs.getString("email"));
        fornecedor.setRua(rs.getString("rua"));
        fornecedor.setBairro(rs.getString("bairro"));
        fornecedor.setCidade(rs.getString("Cidade"));
        fornecedor.setCep(rs.getString("CEP"));
        return fornecedor;
    }
}
