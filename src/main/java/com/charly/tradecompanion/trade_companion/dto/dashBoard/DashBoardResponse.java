package com.charly.tradecompanion.trade_companion.dto.dashBoard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DashBoardResponse {

    private Double Totalscore ;

    private List<TableDashboardResponse> tables = new ArrayList<>() ;

}
