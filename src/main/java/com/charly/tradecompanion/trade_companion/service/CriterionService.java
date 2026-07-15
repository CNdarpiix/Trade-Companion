package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.criterion.CreateCriterion;
import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.CriterionNotFoundException;
import com.charly.tradecompanion.trade_companion.mapper.CriterionMapper;
import com.charly.tradecompanion.trade_companion.repository.AnalysisTableRepository;
import com.charly.tradecompanion.trade_companion.repository.CriterionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriterionService {
    private final CriterionRepository criterionRepository;
    private final AnalysisTableRepository tableRepository ;
    private final CriterionEvaluationService criterionEvaluationService ;

    public CriterionService(CriterionRepository criterionRepository , AnalysisTableRepository analysisTableRepository ,CriterionEvaluationService criterionEvaluationService ) {
        this.criterionRepository = criterionRepository;
        this.tableRepository = analysisTableRepository ;
        this.criterionEvaluationService = criterionEvaluationService ;
    }

    public CriterionResponse createCriterion(CreateCriterion request){
        Long a = 0000L ;
        AnalysisTable table = tableRepository
                .findById(request.getTableId())
                .orElseThrow(
                        () ->   new CriterionNotFoundException(a)

                );

        Criterion criterion = CriterionMapper.toEntity(request);

        criterion.setTable(table);

        criterion = criterionRepository.save(criterion);

        criterionEvaluationService
                .createDefaultEvaluations(
                        criterion
                );

        return CriterionMapper.toResponse(criterion);
    }

    public List<CriterionResponse> getAllCriterion(){
        return criterionRepository
                .findAll()
                .stream()
                .map(CriterionMapper::toResponse)
                .toList();
    }

    public CriterionResponse getCriterionById(Long id){
        return criterionRepository.findById(id).map(CriterionMapper::toResponse) .orElseThrow(
                () -> new CriterionNotFoundException(id)
        );
    }

    public CriterionResponse deleteCriterionById(Long id){
        Criterion crit = criterionRepository.findById(id)
                .orElseThrow(
                () -> new CriterionNotFoundException(id)
        );
        criterionRepository.deleteById(id);
        return CriterionMapper.toResponse(crit);
    }

    public CriterionResponse putCriterion(CreateCriterion request , Long id){
        Criterion crit = criterionRepository.findById(id)
                .orElseThrow(
                        () -> new CriterionNotFoundException(id)
                );
        if (request.getCoefficient() != null)
            crit.setCoefficient(request.getCoefficient());
        if (request.getName() != null)
            crit.setName(request.getName());
        crit.setTable(tableRepository.findById(request.getTableId())
                .orElseThrow(
                () -> new CriterionNotFoundException(id)
        ));

        criterionRepository.save(crit);
        return CriterionMapper.toResponse(crit);
    }
}
