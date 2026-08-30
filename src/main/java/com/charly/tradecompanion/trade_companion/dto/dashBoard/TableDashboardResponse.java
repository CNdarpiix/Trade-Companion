package com.charly.tradecompanion.trade_companion.dto.dashBoard;

import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableDashboardResponse {
    private Long id;

    private Double score;

    private String name ;

    private List<CriterionDashboardResponse> criteria = new ArrayList<>() ;

    private List<TimeFrame> timeFrames ;

}
