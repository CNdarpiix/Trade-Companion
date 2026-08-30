package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.trade.*;
import com.charly.tradecompanion.trade_companion.entity.*;
import com.charly.tradecompanion.trade_companion.entity.snapshot.*;
import com.charly.tradecompanion.trade_companion.enums.TradeStatus;
import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.TradeNotFoundException;
import com.charly.tradecompanion.trade_companion.mapper.TradeMapper;
import com.charly.tradecompanion.trade_companion.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    private final CriterionEvaluationRepository criterionEvaluationRepository;

    public TradeService(TradeRepository tradeRepository, CriterionEvaluationRepository criterionEvaluationRepository) {
        this.tradeRepository = tradeRepository;
        this.criterionEvaluationRepository = criterionEvaluationRepository;
    }

    public TradeResponse createTrade(
            CreateTradeRequest request) {

        Trade trade = TradeMapper.toEntity(request);

        trade.setStatus(TradeStatus.OPEN);

        trade.setOpenedAt(LocalDateTime.now());

        trade.setAnalysis(takeAnalysis());

        trade = tradeRepository.save(trade);

        return TradeMapper.toResponse(trade);
    }

    private AnalysisSnapshot takeAnalysis() {

        AnalysisSnapshot snapshot = new AnalysisSnapshot();

        List<Criterion> criteria = new ArrayList<>();
        List<CriterionEvaluationSnapshot> criterionData = new ArrayList<>();

        Criterion currentCriterion = null;
        CriterionEvaluationSnapshot currentSnapshot = null;

        for (CriterionEvaluation evaluation : criterionEvaluationRepository.findAll()) {

            Criterion criterion = evaluation.getCriterion();

            if (!criteria.contains(criterion)) {

                criteria.add(criterion);

                currentCriterion = criterion;

                currentSnapshot = new CriterionEvaluationSnapshot();
                currentSnapshot.setCriterionEvaluationList(new ArrayList<>());

                criterionData.add(currentSnapshot);
            }

            currentSnapshot.getCriterionEvaluationList().add(evaluation);
        }

        snapshot.setCriterion(criteria);
        snapshot.setCriterionData(criterionData);

        return snapshot;
    }


    public TradeResponse closeTrade(
            CloseTradeRequest tradeRequest,
            Long id
    ) {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));

        trade.setClosedAt(LocalDateTime.now());/// close time

        trade.setExitPrice(tradeRequest.getExitPrice());/// exit Price

        trade.setClosingNote(tradeRequest.getClosingNote());/// Closing note

        trade.setProfit(tradeRequest.getProfit());///Profit

        trade.setStatus(TradeStatus.CLOSED);/// Close the trade

        trade = tradeRepository.save(trade);

        return TradeMapper.toResponse(trade);
    }

    public List<TradeResponse> findAll() {
        return tradeRepository.findAll().stream().map(TradeMapper::toResponse).toList();
    }


    public TradeResponse getTradeById(Long id) {

        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));

        return TradeMapper.toResponse(trade);

    }


    public TradeResponse removeTradeById(Long id) {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));
        tradeRepository.delete(trade);

        return TradeMapper.toResponse(trade);
    }

    public TradeResponse updateTrade(Long id, UpdateTradeRequest tradeRequest) {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));

        if (tradeRequest.getProfit() != null)
            trade.setProfit(tradeRequest.getProfit());

        if (tradeRequest.getExitPrice() != null)
            trade.setExitPrice(tradeRequest.getExitPrice());

        if (tradeRequest.getClosingNote() != null)
            trade.setClosingNote(tradeRequest.getClosingNote());

        if (tradeRequest.getDirection() != null)
            trade.setDirection(tradeRequest.getDirection());

        if (tradeRequest.getSymbol() != null)
            trade.setSymbol(tradeRequest.getSymbol());

        if (tradeRequest.getEntryPrice() != null)
            trade.setEntryPrice(tradeRequest.getEntryPrice());

        if (tradeRequest.getOpeningNote() != null)
            trade.setOpeningNote(tradeRequest.getOpeningNote());

        if (tradeRequest.getTakeProfit() != null)
            trade.setTakeProfit(tradeRequest.getTakeProfit());

        if (tradeRequest.getStopLoss() != null)
            trade.setStopLoss(tradeRequest.getStopLoss());


        trade = tradeRepository.save(trade);

        return TradeMapper.toResponse(trade);
    }
}
