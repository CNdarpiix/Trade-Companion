package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.table.*;
import com.charly.tradecompanion.trade_companion.service.TableService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TableController {

    private TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }


    ///Create Table
    @PostMapping ("/table")
    public TableResponse createTable(@Valid @RequestBody CreateTable request){
        return tableService.createTable(request);
    }

    /// Delete Table
    @DeleteMapping("/table/{id}")
    public TableResponse deleteTableById(@PathVariable Long id){
        return tableService.deleteTableById(id);
    }

    /// Get table and his timeframes
    @GetMapping("/table/{id}")
    public TableResponse getTableById(@PathVariable Long id){
        return tableService.getTableById(id);
    }
    ///GetAll Table
    @GetMapping("/table")
    public List<TableResponse> getAllTable(){
        return tableService.getAllTable();
    }

    ///Editing table and his Timeframes
    @PutMapping("/table/{id}")
    public TableResponse putTableById(@Valid @RequestBody CreateTable request , @PathVariable Long id){
        return tableService.putTableById(request , id);
    }




}
