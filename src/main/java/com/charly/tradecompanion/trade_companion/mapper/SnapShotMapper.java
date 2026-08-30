package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.snapshot.AnalysisSnapshotResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.snapshot.CriterionEvaluationSnapshotResponse;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import com.charly.tradecompanion.trade_companion.entity.snapshot.AnalysisSnapshot;
import com.charly.tradecompanion.trade_companion.entity.snapshot.CriterionEvaluationSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SnapShotMapper {


    public static AnalysisSnapshotResponse toResponse(AnalysisSnapshot analysisSnapshot) {
        AnalysisSnapshotResponse analysis = new AnalysisSnapshotResponse();

        ArrayList<CriterionResponse> criterions = analysisSnapshot.getCriterion().stream().map(CriterionMapper::toResponse).collect(Collectors.toCollection(ArrayList::new));

        List<CriterionEvaluationSnapshotResponse> evaluations = new ArrayList<>();

        for (CriterionEvaluationSnapshot criterionDatum : analysisSnapshot.getCriterionData()) {
            evaluations.add(toResponse(criterionDatum));
        }

        analysis.setCriterion(criterions);
        analysis.setCriterionData(evaluations);

        return analysis;
    }

    public static CriterionEvaluationSnapshotResponse toResponse(CriterionEvaluationSnapshot snapshot) {
        CriterionEvaluationSnapshotResponse response = new CriterionEvaluationSnapshotResponse();
        response.setCriterionEvaluationList(snapshot.getCriterionEvaluationList().stream().map(EvaluationMapper::toResponse).toList());
        return response;
    }
}
