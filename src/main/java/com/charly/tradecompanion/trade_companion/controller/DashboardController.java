package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.dashBoard.DashBoardResponse;
import com.charly.tradecompanion.trade_companion.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashBoardResponse getDashboard() {
        return dashboardService.getDashboard();
    }
}
