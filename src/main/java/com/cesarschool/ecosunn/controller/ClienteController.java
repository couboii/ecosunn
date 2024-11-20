package com.cesarschool.ecosunn.controller;

import com.cesarschool.ecosunn.model.Cliente;
import com.cesarschool.ecosunn.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Endpoint para adicionar um novo cliente
    @PostMapping
    public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente adicionado com sucesso.");
    }

    // Endpoint para buscar cliente por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = clienteService.getClienteByCpf(cpf);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Endpoint para buscar cliente por CNPJ
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Cliente> buscarClientePorCnpj(@PathVariable String cnpj) {
        Cliente cliente = clienteService.getClienteByCnpj(cnpj);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Endpoint para atualizar um cliente
    @PutMapping
    public ResponseEntity<String> atualizarCliente(@RequestBody Cliente cliente) {
        clienteService.updateCliente(cliente);
        return ResponseEntity.ok("Cliente atualizado com sucesso.");
    }

    // Endpoint para excluir um cliente por CPF ou CNPJ
    @DeleteMapping
    public ResponseEntity<String> excluirCliente(@RequestParam(required = false) String cpf,
                                                 @RequestParam(required = false) String cnpj) {
        if ((cpf == null || cpf.isEmpty()) && (cnpj == null || cnpj.isEmpty())) {
            return ResponseEntity.badRequest().body("CPF ou CNPJ deve ser fornecido.");
        }
        clienteService.deleteCliente(cpf, cnpj);
        return ResponseEntity.ok("Cliente excluído com sucesso.");
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/cidades/clientes")
    public ResponseEntity<List<Map<String, Object>>> listarClientesPorCidade() {
        List<Map<String, Object>> clientesPorCidade = clienteService.getClientesPorCidade();
        return ResponseEntity.ok(clientesPorCidade);
    }

}

