package com.charly.tradecompanion.trade_companion.exception;

public class TradeNotFoundException
        extends RuntimeException {

    public TradeNotFoundException(Long id) {

        super("Trade with id " + id + " not found");

    }

}