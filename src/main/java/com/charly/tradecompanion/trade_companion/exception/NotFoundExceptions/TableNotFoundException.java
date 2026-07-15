package com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions;

public class TableNotFoundException
        extends ResourceNotFoundException {

    public TableNotFoundException(Long id) {

        super("Table with id " + id + " not found");

    }

}