package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Parcelado;
import com.cesarschool.ecosunn.service.ParceladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentoparcelado")
public class ParceladoController {

    private final ParceladoService parceladoService;

    @Autowired
    public ParceladoController(ParceladoService parceladoService) {
        this.parceladoService = parceladoService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarParcelado(@RequestBody Parcelado parcelado) {
        parceladoService.addParcelado(parcelado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento parcelado adicionado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcelado> buscarParceladoPorId(@PathVariable int id) {
        Parcelado parcelado = parceladoService.getParceladoById(id);
        return parcelado != null ? ResponseEntity.ok(parcelado) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Parcelado>> listarPagamentosParcelados() {
        return ResponseEntity.ok(parceladoService.getAllPagamentosParcelados());
    }

    @PutMapping
    public ResponseEntity<String> atualizarParcelado(@RequestBody Parcelado parcelado) {
        parceladoService.updateParcelado(parcelado);
        return ResponseEntity.ok("Pagamento parcelado atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirParcelado(@PathVariable int id) {
        parceladoService.deleteParcelado(id);
        return ResponseEntity.ok("Pagamento parcelado excluído com sucesso.");
    }
}

