package com.charly.tradecompanion.trade_companion.dto.evaluation;

import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import com.charly.tradecompanion.trade_companion.enums.AnalysisBias;
import lombok.Data;

@Data
public class EvaluationResponse {
    private Long id ;

    private TimeFrame timeFrame ;

    private Criterion criterion;

    private AnalysisBias bias;
}
