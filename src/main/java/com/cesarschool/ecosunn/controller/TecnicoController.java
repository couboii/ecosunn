package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Tecnico;
import com.cesarschool.ecosunn.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    @Autowired
    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarTecnico(@RequestBody Tecnico tecnico) {
        tecnicoService.addTecnico(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body("Técnico adicionado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> buscarTecnicoPorId(@PathVariable int id) {
        Tecnico tecnico = tecnicoService.getTecnicoById(id);
        return tecnico != null ? ResponseEntity.ok(tecnico) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> listarTecnicos() {
        List<Tecnico> tecnicos = tecnicoService.getAllTecnicos();
        return ResponseEntity.ok(tecnicos);
    }

    @PutMapping
    public ResponseEntity<String> atualizarTecnico(@RequestBody Tecnico tecnico) {
        tecnicoService.updateTecnico(tecnico);
        return ResponseEntity.ok("Técnico atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirTecnico(@PathVariable int id) {
        tecnicoService.deleteTecnico(id);
        return ResponseEntity.ok("Técnico excluído com sucesso.");
    }
}
