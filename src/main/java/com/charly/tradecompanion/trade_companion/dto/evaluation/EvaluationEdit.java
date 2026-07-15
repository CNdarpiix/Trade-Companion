package com.charly.tradecompanion.trade_companion.dto.evaluation;

import com.charly.tradecompanion.trade_companion.enums.AnalysisBias;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EvaluationEdit {
    @NotNull
    private AnalysisBias bias;
}
