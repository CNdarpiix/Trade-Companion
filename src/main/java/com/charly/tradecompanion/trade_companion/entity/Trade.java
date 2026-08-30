package com.charly.tradecompanion.trade_companion.entity;


import com.charly.tradecompanion.trade_companion.enums.TradeDirection;
import com.charly.tradecompanion.trade_companion.enums.TradeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    @Enumerated(EnumType.STRING)
    private TradeDirection direction;

    private Double entryPrice;

    private Double stopLoss;

    private Double takeProfit;

    private String openingNote;

    @Enumerated(EnumType.STRING)
    private TradeStatus status;

    private Double exitPrice;

    private Double profit;

    private String closingNote;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    private AnalysisSnapshot analysis ;

}