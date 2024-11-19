package com.cesarschool.ecosunn.dashboard.impl;

import com.cesarschool.ecosunn.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardRepositoryImpl dashboardRepository;

    @Override
    public long countByCpf() {
        return dashboardRepository.countByCpf();
    }

    @Override
    public long countByCnpj() {
        return dashboardRepository.countByCnpj();
    }
}

