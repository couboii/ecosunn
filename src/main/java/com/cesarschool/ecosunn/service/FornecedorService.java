package com.cesarschool.ecosunn.service;

import com.cesarschool.ecosunn.DAO.FornecedorDAO;
import com.cesarschool.ecosunn.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FornecedorService {

    private final FornecedorDAO fornecedorDAO;

    @Autowired
    public FornecedorService(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    public void addFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null || fornecedor.getCnpj() == null || fornecedor.getNomeEmpresa() == null) {
            throw new IllegalArgumentException("Dados do fornecedor inválidos");
        }
        fornecedorDAO.adicionarFornecedor(fornecedor);
    }

    public Fornecedor getFornecedorByCnpj(String cnpj) {
        return fornecedorDAO.buscarFornecedorPorCnpj(cnpj);
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorDAO.listarFornecedores();
    }

    public void updateFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null || fornecedor.getCnpj() == null || fornecedor.getNomeEmpresa() == null) {
            throw new IllegalArgumentException("Dados do fornecedor inválidos");
        }
        fornecedorDAO.atualizarFornecedor(fornecedor);
    }

    public void deleteFornecedor(String cnpj) {
        fornecedorDAO.excluirFornecedor(cnpj);
    }
    public int getTotalFornecedores() {
        return fornecedorDAO.contarFornecedoresRegistrados();
    }




}

