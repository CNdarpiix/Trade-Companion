package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;

public class EvaluationMapper {

    public static EvaluationResponse toResponse(CriterionEvaluation ev){
        EvaluationResponse resp = new EvaluationResponse() ;
        resp.setId(ev.getId());
        resp.setBias(ev.getBias());
        resp.setTimeFrameId(ev.getTimeFrame().getId());
        resp.setCriterionId(ev.getCriterion().getId());
        return resp ;
    }

}
