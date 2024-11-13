package com.cesarschool.ecosunn.mapper;

import com.cesarschool.ecosunn.model.Supervisor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisorRowMapper implements RowMapper<Supervisor> {

    @Override
    public Supervisor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Supervisor supervisor = new Supervisor();
        supervisor.setTecnicoId(rs.getInt("fk_Tecnico_ID_Tecnico"));
        supervisor.setSupervisorId(rs.getInt("fk_Tecnico_ID_Tecnico_"));
        return supervisor;
    }
}
