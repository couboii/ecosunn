package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.PedidoFaz;
import com.cesarschool.ecosunn.service.PedidoFazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoFazController {

    private final PedidoFazService pedidoFazService;

    @Autowired
    public PedidoFazController(PedidoFazService pedidoFazService) {
        this.pedidoFazService = pedidoFazService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarPedido(@RequestBody PedidoFaz pedido) {
        pedidoFazService.addPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido adicionado com sucesso.");
    }

    @GetMapping
    public ResponseEntity<List<PedidoFaz>> listarPedidos() {
        return ResponseEntity.ok(pedidoFazService.getAllPedidos());
    }

    @GetMapping("/{idPagamento}/{idInstalacao}")
    public ResponseEntity<PedidoFaz> buscarPedidoPorId(@PathVariable int idPagamento, @PathVariable int idInstalacao) {
        PedidoFaz pedido = pedidoFazService.getPedidoById(idPagamento, idInstalacao);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idPagamento}/{idInstalacao}")
    public ResponseEntity<String> excluirPedido(@PathVariable int idPagamento, @PathVariable int idInstalacao) {
        pedidoFazService.deletePedido(idPagamento, idInstalacao);
        return ResponseEntity.ok("Pedido excluído com sucesso.");
    }
}
