package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.dto.evaluation.EvaluationResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.AnalysisSnapshotResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.CreateTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.trade.TradeResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisSnapshot;
import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import com.charly.tradecompanion.trade_companion.entity.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TradeMapper {


    public static Trade toEntity(
            CreateTradeRequest request) {
        Trade trade = new Trade();

        trade.setSymbol(request.getSymbol());

        trade.setDirection(request.getDirection());

        trade.setEntryPrice(request.getEntryPrice());

        trade.setStopLoss(request.getStopLoss());

        trade.setTakeProfit(request.getTakeProfit());

        trade.setOpeningNote(request.getOpeningNote());

        return trade;
    }


    public static TradeResponse toResponse(
            Trade trade) {


        TradeResponse resp = new TradeResponse();
        resp.setId(trade.getId());
        resp.setClosingNote(trade.getClosingNote());
        resp.setClosedAt(trade.getClosedAt());
        resp.setDirection(trade.getDirection());
        resp.setStatus(trade.getStatus());
        resp.setEntryPrice(trade.getEntryPrice());
        resp.setExitPrice(trade.getExitPrice());
        resp.setProfit(trade.getProfit());
        resp.setSymbol(trade.getSymbol());
        resp.setOpenedAt(trade.getOpenedAt());
        resp.setOpeningNote(trade.getOpeningNote());
        resp.setStopLoss(trade.getStopLoss());
        resp.setTakeProfit(trade.getTakeProfit());
        resp.setAnalysis(toResponse(trade.getAnalysis()));

        return resp;
    }

    public static AnalysisSnapshotResponse toResponse(AnalysisSnapshot analysisSnapshot) {
        AnalysisSnapshotResponse analysis = new AnalysisSnapshotResponse();

        ArrayList<CriterionResponse> criterions = analysisSnapshot.getCriterion().stream().map(CriterionMapper::toResponse).collect(Collectors.toCollection(ArrayList::new));

        List<List<EvaluationResponse>> evaluations = new ArrayList<>();

        for (List<CriterionEvaluation> criterionDatum : analysisSnapshot.getCriterionData()) {
            evaluations.add(
                    criterionDatum.stream().map(EvaluationMapper::toResponse).collect(Collectors.toCollection(ArrayList::new))
            );
        }

        analysis.setCriterion(criterions);
        analysis.setCriterionData(evaluations);

        return analysis;
    }
}
