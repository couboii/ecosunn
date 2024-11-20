package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Instalacao;
import com.cesarschool.ecosunn.service.InstalacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    private final InstalacaoService instalacaoService;

    @Autowired
    public InstalacaoController(InstalacaoService instalacaoService) {
        this.instalacaoService = instalacaoService;
    }

    // Endpoint para adicionar uma nova instalação
    @PostMapping
    public ResponseEntity<String> adicionarInstalacao(@RequestBody Instalacao instalacao) {
        instalacaoService.addInstalacao(instalacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Instalação adicionada com sucesso.");
    }

    // Endpoint para buscar uma instalação pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Instalacao> buscarInstalacaoPorId(@PathVariable int id) {
        Instalacao instalacao = instalacaoService.getInstalacaoById(id);
        return instalacao != null ? ResponseEntity.ok(instalacao) : ResponseEntity.notFound().build();
    }

    // Endpoint para listar todas as instalações
    @GetMapping
    public ResponseEntity<List<Instalacao>> listarInstalacoes() {
        List<Instalacao> instalacoes = instalacaoService.getAllInstalacoes();
        return ResponseEntity.ok(instalacoes);
    }

    // Endpoint para atualizar uma instalação
    @PutMapping
    public ResponseEntity<String> atualizarInstalacao(@RequestBody Instalacao instalacao) {
        instalacaoService.updateInstalacao(instalacao);
        return ResponseEntity.ok("Instalação atualizada com sucesso.");
    }

    // Endpoint para excluir uma instalação pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirInstalacao(@PathVariable int id) {
        instalacaoService.deleteInstalacao(id);
        return ResponseEntity.ok("Instalação excluída com sucesso.");
    }
    // Endpoint para contar técnicos associados a uma instalação
    @GetMapping("/{id}/tecnicos/count")
    public ResponseEntity<Integer> contarTecnicosPorInstalacao(@PathVariable int id) {
        int count = instalacaoService.contarTecnicosPorInstalacao(id);
        return ResponseEntity.ok(count);
    }
    @GetMapping("/tecnicos/count")
    public ResponseEntity<List<Map<String, Object>>> contarTecnicosTodasInstalacoes() {
        List<Map<String, Object>> counts = instalacaoService.contarTecnicosTodasInstalacoes();
        return ResponseEntity.ok(counts);
    }

}

