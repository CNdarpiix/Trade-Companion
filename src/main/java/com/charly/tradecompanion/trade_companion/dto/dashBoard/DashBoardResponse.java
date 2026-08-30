package com.charly.tradecompanion.trade_companion.dto.dashBoard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DashBoardResponse {

    private Double totalScore = 0.0;

    private List<TableDashboardResponse> tables = new ArrayList<>() ;

}
