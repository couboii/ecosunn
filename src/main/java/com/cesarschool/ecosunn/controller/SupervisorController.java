package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Supervisor;
import com.cesarschool.ecosunn.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {

    private final SupervisorService supervisorService;

    @Autowired
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarSupervisor(@RequestBody Supervisor supervisor) {
        supervisorService.addSupervisor(supervisor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Supervisor adicionado com sucesso.");
    }

    @GetMapping
    public ResponseEntity<List<Supervisor>> listarSupervisores() {
        return ResponseEntity.ok(supervisorService.getAllSupervisores());
    }

    @DeleteMapping("/{tecnicoId}/{supervisorId}")
    public ResponseEntity<String> excluirSupervisor(@PathVariable int tecnicoId, @PathVariable int supervisorId) {
        supervisorService.deleteSupervisor(tecnicoId, supervisorId);
        return ResponseEntity.ok("Supervisor excluído com sucesso.");
    }



}
