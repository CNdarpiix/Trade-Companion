package com.charly.tradecompanion.trade_companion.dto.trade;

import com.charly.tradecompanion.trade_companion.enums.TradeDirection;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTradeRequest {
    @NotNull
    @Size(min = 2 , max = 15)
    private String symbol;

    @NotNull
    private TradeDirection direction;

    @NotNull
    @Positive
    private Double entryPrice;

    private Double stopLoss;

    private Double takeProfit;

    private String openingNote;

}
