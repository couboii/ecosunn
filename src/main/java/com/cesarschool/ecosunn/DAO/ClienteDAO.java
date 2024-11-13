package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Cliente;
import com.cesarschool.ecosunn.mapper.ClienteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para adicionar um novo cliente no banco de dados
    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (email, nome, rua, bairro, cidade, CEP, telefone, CPF, CNPJ, Clientes_TIPO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getEmail(),
                cliente.getNome(),
                cliente.getRua(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getCep(),
                cliente.getTelefone(),
                cliente.getCpf(),
                cliente.getCnpj(),
                cliente.getTipo()
        );
        System.out.println("Cliente inserido com sucesso.");
    }

    // Método para buscar um cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf) {
        String sql = "SELECT * FROM Clientes WHERE CPF = ?";
        return jdbcTemplate.queryForObject(sql, new ClienteRowMapper(), cpf);
    }

    // Método para buscar um cliente pelo CNPJ
    public Cliente buscarClientePorCnpj(String cnpj) {
        String sql = "SELECT * FROM Clientes WHERE CNPJ = ?";
        return jdbcTemplate.queryForObject(sql, new ClienteRowMapper(), cnpj);
    }

    // Método para atualizar um cliente no banco de dados
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET email = ?, nome = ?, rua = ?, bairro = ?, cidade = ?, CEP = ?, telefone = ?, Clientes_TIPO = ? WHERE CPF = ? OR CNPJ = ?";
        jdbcTemplate.update(sql,
                cliente.getEmail(),
                cliente.getNome(),
                cliente.getRua(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getCep(),
                cliente.getTelefone(),
                cliente.getTipo(),
                cliente.getCpf(),
                cliente.getCnpj()
        );
        System.out.println("Cliente atualizado com sucesso.");
    }

    // Método para excluir um cliente do banco de dados
    public void excluirCliente(String cpf, String cnpj) {
        String sql = "DELETE FROM Clientes WHERE CPF = ? OR CNPJ = ?";
        jdbcTemplate.update(sql, cpf, cnpj);
        System.out.println("Cliente excluído com sucesso.");
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Clientes";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }
}
