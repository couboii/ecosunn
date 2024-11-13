package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.FormaPagamento;
import com.cesarschool.ecosunn.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formaspagamento")
public class FormaPagamentoController {

    private final FormaPagamentoService formaPagamentoService;

    @Autowired
    public FormaPagamentoController(FormaPagamentoService formaPagamentoService) {
        this.formaPagamentoService = formaPagamentoService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        formaPagamentoService.addFormaPagamento(formaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Forma de pagamento adicionada com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> buscarFormaPagamentoPorId(@PathVariable int id) {
        FormaPagamento formaPagamento = formaPagamentoService.getFormaPagamentoById(id);
        return formaPagamento != null ? ResponseEntity.ok(formaPagamento) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> listarFormasPagamento() {
        return ResponseEntity.ok(formaPagamentoService.getAllFormasPagamento());
    }

    @PutMapping
    public ResponseEntity<String> atualizarFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        formaPagamentoService.updateFormaPagamento(formaPagamento);
        return ResponseEntity.ok("Forma de pagamento atualizada com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFormaPagamento(@PathVariable int id) {
        formaPagamentoService.deleteFormaPagamento(id);
        return ResponseEntity.ok("Forma de pagamento excluída com sucesso.");
    }
}
