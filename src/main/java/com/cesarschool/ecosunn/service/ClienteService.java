package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.model.Cliente;
import com.cesarschool.ecosunn.DAO.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Adicionar um novo cliente
    public boolean addCliente(Cliente cliente) {
        if (cliente == null || cliente.getNome() == null || cliente.getEmail() == null) {
            System.out.println("Dados do cliente inválidos");
            return false;
        }
        clienteDAO.adicionarCliente(cliente);
        return true;
    }

    // Obter um cliente pelo CPF
    public Cliente getClienteByCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            System.out.println("CPF inválido");
            return null;
        }
        return clienteDAO.buscarClientePorCpf(cpf);
    }

    // Obter um cliente pelo CNPJ
    public Cliente getClienteByCnpj(String cnpj) {
        if (cnpj == null || cnpj.isEmpty()) {
            System.out.println("CNPJ inválido");
            return null;
        }
        return clienteDAO.buscarClientePorCnpj(cnpj);
    }

    // Atualizar um cliente
    public boolean updateCliente(Cliente cliente) {
        if (cliente == null || cliente.getNome() == null || cliente.getEmail() == null) {
            System.out.println("Dados do cliente inválidos");
            return false;
        }
        clienteDAO.atualizarCliente(cliente);
        return true;
    }

    // Deletar um cliente usando CPF e CNPJ
    public boolean deleteCliente(String cpf, String cnpj) {
        if ((cpf == null || cpf.isEmpty()) && (cnpj == null || cnpj.isEmpty())) {
            System.out.println("CPF e CNPJ inválidos");
            return false;
        }
        clienteDAO.excluirCliente(cpf, cnpj);
        return true;
    }

    // Listar todos os clientes
    public List<Cliente> getAllClientes() {
        return clienteDAO.listarClientes();
    }
}
