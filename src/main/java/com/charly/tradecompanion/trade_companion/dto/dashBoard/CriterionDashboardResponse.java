package com.charly.tradecompanion.trade_companion.dto.dashBoard;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CriterionDashboardResponse {
    private Long id;

    private String name;

    private Double coefficient;

    private Double score;

    private List<EvaluationResponse> evaluations = new ArrayList<>();

}
