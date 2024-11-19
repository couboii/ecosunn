package com.cesarschool.ecosunn.dashboard.impl;

import com.cesarschool.ecosunn.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private DashboardRepositoryImpl dashboardRepository;

    public DashboardServiceImpl(DashboardRepositoryImpl dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public Map<String, Long> contagemTipoClientes(){
    Map<String, Long> tiposClientes = new HashMap<>();
        tiposClientes.put("CPF", dashboardRepository.countByCpf());
        tiposClientes.put("CNPJ", dashboardRepository.countByCnpj());
        return tiposClientes;
        }
}

