package com.charly.tradecompanion.trade_companion.mapper;

import com.charly.tradecompanion.trade_companion.dto.table.CreateTable;
import com.charly.tradecompanion.trade_companion.dto.table.TableResponse;
import com.charly.tradecompanion.trade_companion.dto.trade.CreateTradeRequest;
import com.charly.tradecompanion.trade_companion.dto.trade.TradeResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Trade;

public class TableMapper {


    public static AnalysisTable toEntity(
            CreateTable request) {
        AnalysisTable table = new AnalysisTable();

        table.setName(request.getName());
        table.getTimeFrames().addAll(request.getTimeFrames());

        return table;
    }


    public static TableResponse toResponse(
            AnalysisTable table) {


        TableResponse resp = new TableResponse();

        resp.setName(table.getName());
        resp.setId(table.getId());
        resp.getTimeFrames().addAll(table.getTimeFrames());
        return resp;
    }
}
