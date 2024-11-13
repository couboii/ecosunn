package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Instalacao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstalacaoRowMapper implements RowMapper<Instalacao> {

    @Override
    public Instalacao mapRow(ResultSet rs, int rowNum) throws SQLException {
        Instalacao instalacao = new Instalacao();
        instalacao.setIdInstalacao(rs.getInt("ID_instalacao"));
        instalacao.setComentarioServico(rs.getString("comentario_servico"));
        instalacao.setDataInstalacao(rs.getString("data_instalacao"));
        return instalacao;
    }
}
