package com.charly.tradecompanion.trade_companion.dto.trade.snapshot;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CriterionEvaluationSnapshotResponse {

    private List<EvaluationResponse> criterionEvaluationList;
}
