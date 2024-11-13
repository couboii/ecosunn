package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.AVista;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AVistaRowMapper implements RowMapper<AVista> {

    @Override
    public AVista mapRow(ResultSet rs, int rowNum) throws SQLException {
        AVista aVista = new AVista();
        aVista.setIdPagamento(rs.getInt("fk_Forma_Pagamento_ID_Pagamento"));
        aVista.setDesconto(rs.getDouble("desconto"));
        return aVista;
    }
}
