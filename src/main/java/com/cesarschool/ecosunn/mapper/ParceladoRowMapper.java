package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Parcelado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParceladoRowMapper implements RowMapper<Parcelado> {

    @Override
    public Parcelado mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parcelado parcelado = new Parcelado();
        parcelado.setIdPagamento(rs.getInt("fk_Forma_Pagamento_ID_Pagamento"));
        parcelado.setQtdParcelas(rs.getInt("qdt_parcelas"));
        parcelado.setValorParcela(rs.getDouble("valor_parcela"));
        return parcelado;
    }
}

