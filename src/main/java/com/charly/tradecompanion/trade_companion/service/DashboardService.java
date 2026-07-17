package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.dashBoard.CriterionDashboardResponse;
import com.charly.tradecompanion.trade_companion.dto.dashBoard.DashBoardResponse;
import com.charly.tradecompanion.trade_companion.dto.dashBoard.TableDashboardResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import com.charly.tradecompanion.trade_companion.mapper.EvaluationMapper;
import com.charly.tradecompanion.trade_companion.mapper.dashboardMapper.DashboardMapper;
import com.charly.tradecompanion.trade_companion.repository.AnalysisTableRepository;
import com.charly.tradecompanion.trade_companion.repository.CriterionEvaluationRepository;
import com.charly.tradecompanion.trade_companion.repository.CriterionRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final AnalysisTableRepository tableRepository;
    private final CriterionRepository criterionRepository;
    private final CriterionEvaluationRepository criterionEvaluationRepository ;

    public DashboardService(AnalysisTableRepository tableRepository, CriterionRepository criterionRepository , CriterionEvaluationRepository criterionEvaluationRepository) {
        this.tableRepository = tableRepository;
        this.criterionRepository = criterionRepository;
        this.criterionEvaluationRepository = criterionEvaluationRepository ;
    }

    public DashBoardResponse getDashboard() {
        DashBoardResponse response = new DashBoardResponse();

        for (AnalysisTable table : tableRepository.findAll()) {

            TableDashboardResponse tableDashboardResponse =
                    DashboardMapper.toTableDashboardResponse(table);

            for (Criterion criterion :
                    criterionRepository.findByTableId(table.getId())) {

                CriterionDashboardResponse criterionDashboardResponse =
                        DashboardMapper
                                .toCriterionDashboardResponse(criterion);

                tableDashboardResponse
                        .getCriteria()
                        .add(criterionDashboardResponse);

                for (CriterionEvaluation criterionEvaluation :
                        criterionEvaluationRepository
                                .findByCriterionId(criterion.getId())) {

                    criterionDashboardResponse
                            .getEvaluations()
                            .add(
                                    EvaluationMapper
                                            .toResponse(
                                                    criterionEvaluation
                                            )
                            );
                }
            }

            response.getTables().add(tableDashboardResponse);
        }

        return response;
    }

}
