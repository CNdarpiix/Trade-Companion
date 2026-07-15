package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;

public class EvaluationMapper {

    public static EvaluationResponse toResponse(CriterionEvaluation ev){
        EvaluationResponse resp = new EvaluationResponse() ;
        resp.setId(ev.getId());
        resp.setBias(ev.getBias());
        resp.setTimeFrame(ev.getTimeFrame());
        resp.setCriterion(ev.getCriterion());
        return resp ;
    }

}
