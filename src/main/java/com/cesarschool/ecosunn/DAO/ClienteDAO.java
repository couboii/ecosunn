package com.cesarschool.ecosunn.DAO;

import com.cesarschool.ecosunn.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDAO {

    private final DataSource dataSource;

    @Autowired
    public ClienteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Método para adicionar um novo cliente no banco de dados
    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (email, nome, rua, bairro, cidade, CEP, telefone, CPF, CNPJ, Clientes_TIPO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getRua());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCidade());
            stmt.setInt(6, cliente.getCep());
            stmt.setString(7, cliente.getTelefone());
            stmt.setString(8, cliente.getCpf());

            if (cliente.getCnpj() != null) {
                stmt.setString(9, cliente.getCnpj());
            } else {
                stmt.setNull(9, Types.VARCHAR);
            }

            stmt.setInt(10, cliente.getTipo());

            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucessoo.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // Método para buscar um cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf) {
        String sql = "SELECT * FROM Clientes WHERE CPF = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente por CPF: " + e.getMessage());
        }
        return null;
    }

    // Método para buscar um cliente pelo CNPJ
    public Cliente buscarClientePorCnpj(String cnpj) {
        String sql = "SELECT * FROM Clientes WHERE CNPJ = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente por CNPJ: " + e.getMessage());
        }
        return null;
    }

    // Método para atualizar um cliente no banco de dados
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET email = ?, nome = ?, rua = ?, bairro = ?, cidade = ?, CEP = ?, telefone = ?, Clientes_TIPO = ? WHERE CPF = ? OR CNPJ = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getRua());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCidade());
            stmt.setInt(6, cliente.getCep());
            stmt.setString(7, cliente.getTelefone());
            stmt.setInt(8, cliente.getTipo());
            stmt.setString(9, cliente.getCpf());
            stmt.setString(10, cliente.getCnpj());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Método para excluir um cliente do banco de dados
    public void excluirCliente(String cpf, String cnpj) {
        String sql = "DELETE FROM Clientes WHERE CPF = ? OR CNPJ = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setString(2, cnpj);
            stmt.executeUpdate();
            System.out.println("Cliente excluído com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(mapearCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Método auxiliar para mapear os dados do ResultSet para o objeto Cliente
    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setEmail(rs.getString("email"));
        cliente.setNome(rs.getString("nome"));
        cliente.setRua(rs.getString("rua"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setCidade(rs.getString("cidade"));
        cliente.setCep(rs.getInt("CEP"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setCpf(rs.getString("CPF"));
        cliente.setCnpj(rs.getString("CNPJ"));
        cliente.setTipo(rs.getInt("Clientes_TIPO"));
        return cliente;
    }
}


