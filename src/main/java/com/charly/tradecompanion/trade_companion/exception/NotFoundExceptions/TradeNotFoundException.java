package com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions;

public class TradeNotFoundException
        extends ResourceNotFoundException {

    public TradeNotFoundException(Long id) {

        super("Trade with id " + id + " not found");

    }

}