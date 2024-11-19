package com.cesarschool.ecosunn.dashboard.impl;

import com.cesarschool.ecosunn.dashboard.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DashboardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long countByCpf() {
        String sql = "SELECT COUNT(*) FROM Clientes WHERE CPF IS NOT NULL AND CNPJ IS NULL";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public long countByCnpj() {
        String sql = "SELECT COUNT(*) FROM Clientes WHERE CNPJ IS NOT NULL AND CPF IS NULL";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}

