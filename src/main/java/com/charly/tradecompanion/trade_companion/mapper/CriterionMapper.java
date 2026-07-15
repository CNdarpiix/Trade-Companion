package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.criterion.CreateCriterion;
import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.entity.Criterion;

public class CriterionMapper {

    public static CriterionResponse toResponse(Criterion request){
        CriterionResponse resp = new CriterionResponse();
        resp.setId(request.getId());
        resp.setCoefficient(request.getCoefficient());
        resp.setName(request.getName());
        resp.setTable(request.getTable().getId());

        return resp ;
    }

    public static Criterion toEntity(CreateCriterion request){

        Criterion criterion = new Criterion();

        criterion.setName(request.getName());

        criterion.setCoefficient(request.getCoefficient());

        return criterion;
    }
}
