package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Fornecedor;
import com.cesarschool.ecosunn.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.addFornecedor(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor adicionado com sucesso.");
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorCnpj(@PathVariable String cnpj) {
        Fornecedor fornecedor = fornecedorService.getFornecedorByCnpj(cnpj);
        return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        return ResponseEntity.ok(fornecedorService.getAllFornecedores());
    }

    @PutMapping
    public ResponseEntity<String> atualizarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.updateFornecedor(fornecedor);
        return ResponseEntity.ok("Fornecedor atualizado com sucesso.");
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> excluirFornecedor(@PathVariable String cnpj) {
        fornecedorService.deleteFornecedor(cnpj);
        return ResponseEntity.ok("Fornecedor excluído com sucesso.");
    }
}
