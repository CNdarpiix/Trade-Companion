package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.table.*;
import com.charly.tradecompanion.trade_companion.service.TableService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {

    private TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping ("/Table")
    public TableResponse createTable(@Valid @RequestBody CreateTable request){
        return tableService.createTable(request);
    }
}
