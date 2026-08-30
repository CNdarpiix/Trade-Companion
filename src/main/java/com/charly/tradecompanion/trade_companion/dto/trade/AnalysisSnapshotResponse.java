package com.charly.tradecompanion.trade_companion.dto.trade;

import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AnalysisSnapshotResponse {

    private List<CriterionResponse> criterion ;

    private List<List<EvaluationResponse>> criterionData ;

}
