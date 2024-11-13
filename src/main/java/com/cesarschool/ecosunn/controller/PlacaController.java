package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Placa;
import com.cesarschool.ecosunn.service.PlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placas")
public class PlacaController {

    private final PlacaService placaService;

    @Autowired
    public PlacaController(PlacaService placaService) {
        this.placaService = placaService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarPlaca(@RequestBody Placa placa) {
        placaService.addPlaca(placa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Placa adicionada com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placa> buscarPlacaPorId(@PathVariable int id) {
        Placa placa = placaService.getPlacaById(id);
        return placa != null ? ResponseEntity.ok(placa) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Placa>> listarPlacas() {
        return ResponseEntity.ok(placaService.getAllPlacas());
    }

    @PutMapping
    public ResponseEntity<String> atualizarPlaca(@RequestBody Placa placa) {
        placaService.updatePlaca(placa);
        return ResponseEntity.ok("Placa atualizada com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPlaca(@PathVariable int id) {
        placaService.deletePlaca(id);
        return ResponseEntity.ok("Placa excluída com sucesso.");
    }
}

