package com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super((message));
    }
}
