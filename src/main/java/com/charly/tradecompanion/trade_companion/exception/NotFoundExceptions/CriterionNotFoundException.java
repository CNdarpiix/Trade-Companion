package com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions;

public class CriterionNotFoundException
        extends ResourceNotFoundException {

    public CriterionNotFoundException(Long id) {

        super("Criterion with id " + id + " not found");

    }

}