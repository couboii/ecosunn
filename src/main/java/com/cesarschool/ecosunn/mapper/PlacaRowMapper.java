package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Placa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlacaRowMapper implements RowMapper<Placa> {

    @Override
    public Placa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Placa placa = new Placa();
        placa.setIdPlaca(rs.getInt("ID_placa"));
        placa.setPotenciaPlaca(rs.getString("Potencia_placa"));
        placa.setQtdPlacas(rs.getInt("qtd_placas"));
        placa.setPrazoGarantia(rs.getString("prazo_garantia"));
        placa.setInstalacaoId(rs.getInt("fk_Instalacao_ID_instalacao"));
        placa.setFornecedorCnpj(rs.getString("fk_Fornecedor_CNPJ"));
        return placa;
    }
}
