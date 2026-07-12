package com.charly.tradecompanion.trade_companion.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CloseTradeRequest {

    @NotNull
    private Double profit ;

    @NotNull
    @Positive
    private Double exitPrice;

    private String closingNote;

}
