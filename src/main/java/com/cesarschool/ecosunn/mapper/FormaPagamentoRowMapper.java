package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.FormaPagamento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormaPagamentoRowMapper implements RowMapper<FormaPagamento> {

    @Override
    public FormaPagamento mapRow(ResultSet rs, int rowNum) throws SQLException {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdPagamento(rs.getInt("ID_Pagamento"));
        formaPagamento.setValorTotal(rs.getDouble("valor_total"));
        formaPagamento.setDataEmissao(rs.getString("data_emissao"));
        return formaPagamento;
    }
}
