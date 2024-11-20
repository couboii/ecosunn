package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.model.Cliente;
import com.cesarschool.ecosunn.DAO.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Adicionar um novo cliente
    public void addCliente(Cliente cliente) {
        if (cliente == null || cliente.getNome() == null || cliente.getEmail() == null) {
            throw new IllegalArgumentException("Dados do cliente inválidos");
        }
        clienteDAO.adicionarCliente(cliente);
    }

    // Obter um cliente pelo CPF
    public Cliente getClienteByCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return clienteDAO.buscarClientePorCpf(cpf);
    }

    // Obter um cliente pelo CNPJ
    public Cliente getClienteByCnpj(String cnpj) {
        if (cnpj == null || cnpj.isEmpty()) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        return clienteDAO.buscarClientePorCnpj(cnpj);
    }

    // Atualizar um cliente
    public void updateCliente(Cliente cliente) {
        if (cliente == null || cliente.getNome() == null || cliente.getEmail() == null) {
            throw new IllegalArgumentException("Dados do cliente inválidos");
        }
        clienteDAO.atualizarCliente(cliente);
    }

    // Deletar um cliente usando CPF ou CNPJ
    public void deleteCliente(String cpf, String cnpj) {
        if ((cpf == null || cpf.isEmpty()) && (cnpj == null || cnpj.isEmpty())) {
            throw new IllegalArgumentException("CPF ou CNPJ deve ser fornecido.");
        }
        clienteDAO.excluirCliente(cpf, cnpj);
    }

    // Listar todos os clientes
    public List<Cliente> getAllClientes() {
        return clienteDAO.listarClientes();
    }

    public long countByCpf() {
        return clienteDAO.countByCpf();
    }

    public long countByCnpj() {
        return clienteDAO.countByCnpj();
    }
    public List<Map<String, Object>> getClientesPorCidade() {
        return clienteDAO.contarClientesPorCidade();
    }





}
