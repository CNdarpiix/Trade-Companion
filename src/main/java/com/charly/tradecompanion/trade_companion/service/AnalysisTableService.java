package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.table.TableResponse;
import com.charly.tradecompanion.trade_companion.repository.AnalysisTableRepository;

public class AnalysisTableService {
    private final AnalysisTableRepository analysisTableRepository;

    public AnalysisTableService(AnalysisTableRepository analysisTableRepository) {
        this.analysisTableRepository = analysisTableRepository;
    }

    public TableResponse createTable(){

    }
}
