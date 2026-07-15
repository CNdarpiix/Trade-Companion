package com.charly.tradecompanion.trade_companion.exception;

import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.ResourceNotFoundException;
import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.TradeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TradeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex
    ) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorResponse(
                                ex.getMessage()
                        )
                );
    }
}