package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Supervisor;
import com.cesarschool.ecosunn.mapper.SupervisorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupervisorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SupervisorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarSupervisor(Supervisor supervisor) {
        String sql = "INSERT INTO supervisor (fk_Tecnico_ID_Tecnico, fk_Tecnico_ID_Tecnico_) VALUES (?, ?)";
        jdbcTemplate.update(sql, supervisor.getTecnicoId(), supervisor.getSupervisorId());
    }

    public List<Supervisor> listarSupervisores() {
        String sql = "SELECT * FROM supervisor";
        return jdbcTemplate.query(sql, new SupervisorRowMapper());
    }

    public void excluirSupervisor(int tecnicoId, int supervisorId) {
        String sql = "DELETE FROM supervisor WHERE fk_Tecnico_ID_Tecnico = ? AND fk_Tecnico_ID_Tecnico_ = ?";
        jdbcTemplate.update(sql, tecnicoId, supervisorId);
    }



}
