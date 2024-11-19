package com.cesarschool.ecosunn.dashboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("tipo")
    public ResponseEntity<Map<String, Long>> getTipoClientes() {
        return ResponseEntity.ok(dashboardService.contagemTipoClientes());
    }
}
