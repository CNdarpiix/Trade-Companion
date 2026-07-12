package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.*;
import com.charly.tradecompanion.trade_companion.entity.Trade;
import com.charly.tradecompanion.trade_companion.enums.TradeStatus;
import com.charly.tradecompanion.trade_companion.mapper.TradeMapper;
import com.charly.tradecompanion.trade_companion.repository.TradeRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradeService {
    private TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public TradeResponse createTrade(
            CreateTradeRequest request) {

        Trade trade = TradeMapper.toEntity(request);

        trade.setStatus(TradeStatus.OPEN);

        trade.setOpenedAt(LocalDateTime.now());

        trade = tradeRepository.save(trade);

        return TradeMapper.toResponse(trade);
    }

    public TradeResponse closeTrade(
            CloseTradeRequest tradeRequest,
            Long id
    ) {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow();

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
                .orElseThrow();

        return TradeMapper.toResponse(trade);

    }
}
