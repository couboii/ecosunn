package com.cesarschool.ecosunn.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/tipo-clientes")
    public ResponseEntity<Map<String, Long>> getTipoClientes() {
        Map<String, Long> tiposClientes = new HashMap<>();
        tiposClientes.put("CPF", dashboardService.countByCpf());
        tiposClientes.put("CNPJ", dashboardService.countByCnpj());
        return ResponseEntity.ok(tiposClientes);
    }
}
