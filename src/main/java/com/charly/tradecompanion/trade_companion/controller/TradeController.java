package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.CloseTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.CreateTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.TradeResponse;
import com.charly.tradecompanion.trade_companion.service.TradeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TradeController {

    /// Repository

    private final TradeService tradeService;

    /// Constructor

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /// test


    @GetMapping("/trade/test")
    public String test() {
        return "Trade Companion OK";
    }

    /// Oppening trade
    @PostMapping("/trade")
    public TradeResponse createTrade(@RequestBody CreateTradeRequest trade) {
        return tradeService.createTrade(trade);
    }

    /// Closing trade
    @PutMapping("/trade/{id}/close")
    public TradeResponse closeTrade(@PathVariable Long id, @RequestBody CloseTradeRequest tradeData) {
        return tradeService.closeTrade(tradeData , id);
    }

    /// get all trades

    @GetMapping("/trade")
    public List<TradeResponse> getAllTrades() {
        return tradeService.findAll();
    }

    /// Get trade by ID
    @GetMapping("/trade/{id}")
    public TradeResponse getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }
}
