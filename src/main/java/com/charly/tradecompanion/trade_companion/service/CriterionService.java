package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.criterion.CreateCriterion;
import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Criterion;
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
        AnalysisTable table = tableRepository
                .findById(request.getTable())
                .orElseThrow();

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
        return criterionRepository.findById(id).map(CriterionMapper::toResponse).orElseThrow();
    }

    public CriterionResponse deleteCriterionById(Long id){
        Criterion crit = criterionRepository.findById(id).orElseThrow();
        criterionRepository.deleteById(id);
        return CriterionMapper.toResponse(crit);
    }

    public CriterionResponse putCriterion(CreateCriterion request , Long id){
        Criterion crit = criterionRepository.findById(id)
                .orElseThrow();
        crit.setCoefficient(request.getCoefficient());
        crit.setName(request.getName());
        crit.setTable(tableRepository.findById(request.getTable())
                .orElseThrow());

        criterionRepository.save(crit);
        return CriterionMapper.toResponse(crit);
    }
}
