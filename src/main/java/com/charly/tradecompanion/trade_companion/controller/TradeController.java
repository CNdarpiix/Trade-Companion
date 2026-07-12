package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.trade.CloseTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.trade.CreateTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.trade.TradeResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.UpdateTradeRequest;
import com.charly.tradecompanion.trade_companion.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public TradeResponse createTrade(@Valid @RequestBody CreateTradeRequest trade) {
        return tradeService.createTrade(trade);
    }

    /// Closing trade
    @PutMapping("/trade/{id}/close")
    public TradeResponse closeTrade(@PathVariable Long id, @Valid @RequestBody CloseTradeRequest tradeData) {
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

    @DeleteMapping("/trade/{id}")
    public TradeResponse removeTradeById(@PathVariable Long id){
        return tradeService.removeTradeById(id);
    }

    @PutMapping("/trade/{id}")
    public TradeResponse updateTradeById(@PathVariable Long id , @RequestBody UpdateTradeRequest request){
        return tradeService.updateTrade(id , request);
    }
}
