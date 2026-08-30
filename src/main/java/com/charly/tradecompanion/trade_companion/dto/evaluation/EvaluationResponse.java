package com.charly.tradecompanion.trade_companion.dto.evaluation;


import com.charly.tradecompanion.trade_companion.enums.AnalysisBias;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;



@Data
public class EvaluationResponse {

    private Long id ;

    private Long timeFrameId ;

    private Long criterionId ;

    @Enumerated(EnumType.STRING)
    private AnalysisBias bias;
}
