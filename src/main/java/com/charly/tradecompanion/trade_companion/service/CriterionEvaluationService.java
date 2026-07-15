package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationEdit;
import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import com.charly.tradecompanion.trade_companion.enums.AnalysisBias;
import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.EvaluationNotFoundException;
import com.charly.tradecompanion.trade_companion.mapper.EvaluationMapper;
import com.charly.tradecompanion.trade_companion.repository.CriterionEvaluationRepository;
import org.springframework.stereotype.Service;



@Service
public class CriterionEvaluationService {
    private final CriterionEvaluationRepository evaluationRepository ;

    public  CriterionEvaluationService(CriterionEvaluationRepository evaluationRepository){
        this.evaluationRepository = evaluationRepository ;
    }

    public void createDefaultEvaluations(
            Criterion criterion
    ) {
        AnalysisTable table = criterion.getTable();

        for (TimeFrame tf : table.getTimeFrames()) {

            CriterionEvaluation evaluation =
                    new CriterionEvaluation();

            evaluation.setCriterion(criterion);

            evaluation.setTimeFrame(tf);

            evaluation.setBias(AnalysisBias.NEUTRAL);

            evaluationRepository.save(evaluation);
        }
    }

    public EvaluationResponse updateBias(
            Long id,
            EvaluationEdit request
    ){
        CriterionEvaluation evaluation =
                evaluationRepository.findById(id)
                        .orElseThrow(
                                () -> new EvaluationNotFoundException(id)
                        );

        evaluation.setBias(request.getBias());

        evaluation = evaluationRepository.save(evaluation);

        return EvaluationMapper.toResponse(evaluation);
    }

}
