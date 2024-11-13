package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Tecnico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TecnicoRowMapper implements RowMapper<Tecnico> {

    @Override
    public Tecnico mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tecnico tecnico = new Tecnico();
        tecnico.setIdTecnico(rs.getInt("ID_Tecnico"));
        tecnico.setNome(rs.getString("Nome"));
        tecnico.setTelefone(rs.getString("Telefone"));
        tecnico.setEmail(rs.getString("Email"));
        tecnico.setInstalacaoId(rs.getInt("fk_Instalacao_ID_instalacao"));
        return tecnico;
    }
}
