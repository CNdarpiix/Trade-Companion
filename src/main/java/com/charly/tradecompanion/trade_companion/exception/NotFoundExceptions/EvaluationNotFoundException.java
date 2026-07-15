package com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions;

public class EvaluationNotFoundException
        extends ResourceNotFoundException {

    public EvaluationNotFoundException(Long id) {

        super("Evaluation with id " + id + " not found");

    }

}