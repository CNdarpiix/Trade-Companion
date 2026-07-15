package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationEdit;
import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.service.CriterionEvaluationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {
    private final CriterionEvaluationService evaluationService;

    public EvaluationController(CriterionEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PutMapping("/evaluation/{id}")
    public EvaluationResponse editBiasEvaluation(@PathVariable Long id , @Valid @RequestBody EvaluationEdit request){
        return evaluationService.updateBias(id , request);
    }
}
