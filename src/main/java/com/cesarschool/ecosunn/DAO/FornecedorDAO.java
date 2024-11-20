package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Fornecedor;
import com.cesarschool.ecosunn.mapper.FornecedorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FornecedorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FornecedorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome_Empresa, telefone, email, rua, bairro, Cidade, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, fornecedor.getCnpj(), fornecedor.getNomeEmpresa(), fornecedor.getTelefone(),
                fornecedor.getEmail(), fornecedor.getRua(), fornecedor.getBairro(), fornecedor.getCidade(), fornecedor.getCep());
    }

    public Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ = ?";
        return jdbcTemplate.queryForObject(sql, new FornecedorRowMapper(), cnpj);
    }

    public List<Fornecedor> listarFornecedores() {
        String sql = "SELECT * FROM Fornecedor";
        return jdbcTemplate.query(sql, new FornecedorRowMapper());
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET Nome_Empresa = ?, telefone = ?, email = ?, rua = ?, bairro = ?, Cidade = ?, CEP = ? WHERE CNPJ = ?";
        jdbcTemplate.update(sql, fornecedor.getNomeEmpresa(), fornecedor.getTelefone(), fornecedor.getEmail(),
                fornecedor.getRua(), fornecedor.getBairro(), fornecedor.getCidade(), fornecedor.getCep(), fornecedor.getCnpj());
    }

    public void excluirFornecedor(String cnpj) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";
        jdbcTemplate.update(sql, cnpj);
    }
    public int contarFornecedoresRegistrados() {
        String sql = "SELECT COUNT(*) FROM Fornecedor";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }




}
