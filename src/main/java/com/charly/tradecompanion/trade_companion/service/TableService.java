package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.table.CreateTable;
import com.charly.tradecompanion.trade_companion.dto.table.TableResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.mapper.TableMapper;
import com.charly.tradecompanion.trade_companion.repository.AnalysisTableRepository;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    private final AnalysisTableRepository analysisTableRepository;

    public TableService(AnalysisTableRepository analysisTableRepository) {
        this.analysisTableRepository = analysisTableRepository;
    }

    public TableResponse createTable(CreateTable request) {
        AnalysisTable table = TableMapper.toEntity(request);
        table = analysisTableRepository.save(table);
        return TableMapper.toResponse(table);
    }
}
