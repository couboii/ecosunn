package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.AVista;
import com.cesarschool.ecosunn.service.AVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentoavista")
public class AVistaController {

    private final AVistaService aVistaService;

    @Autowired
    public AVistaController(AVistaService aVistaService) {
        this.aVistaService = aVistaService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarAVista(@RequestBody AVista aVista) {
        aVistaService.addAVista(aVista);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento à vista adicionado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AVista> buscarAVistaPorId(@PathVariable int id) {
        AVista aVista = aVistaService.getAVistaById(id);
        return aVista != null ? ResponseEntity.ok(aVista) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AVista>> listarPagamentosAVista() {
        return ResponseEntity.ok(aVistaService.getAllPagamentosAVista());
    }

    @PutMapping
    public ResponseEntity<String> atualizarAVista(@RequestBody AVista aVista) {
        aVistaService.updateAVista(aVista);
        return ResponseEntity.ok("Pagamento à vista atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAVista(@PathVariable int id) {
        aVistaService.deleteAVista(id);
        return ResponseEntity.ok("Pagamento à vista excluído com sucesso.");
    }
}

