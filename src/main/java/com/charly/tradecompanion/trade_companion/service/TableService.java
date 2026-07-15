package com.charly.tradecompanion.trade_companion.service;

import com.charly.tradecompanion.trade_companion.dto.table.CreateTable;
import com.charly.tradecompanion.trade_companion.dto.table.TableResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.exception.NotFoundExceptions.TableNotFoundException;
import com.charly.tradecompanion.trade_companion.mapper.TableMapper;
import com.charly.tradecompanion.trade_companion.repository.AnalysisTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public TableResponse deleteTableById(Long id){
        AnalysisTable table = analysisTableRepository.findById(id)
                .orElseThrow(
                        () -> new TableNotFoundException(id)
                );

        analysisTableRepository.delete(table);

        return TableMapper.toResponse(table) ;
    }

    public TableResponse getTableById(Long id){
        AnalysisTable table = analysisTableRepository.findById(id)
                .orElseThrow(
                        () -> new TableNotFoundException(id)
                );

        return TableMapper.toResponse(table) ;
    }

    public List<TableResponse> getAllTable(){
        return analysisTableRepository
                .findAll()
                .stream()
                .map(TableMapper::toResponse)
                .toList();
    }

    public TableResponse putTableById(CreateTable request , Long id){
        AnalysisTable table = analysisTableRepository.findById(id)
                .orElseThrow(
                        () -> new TableNotFoundException(id)
                );
        if (request.getName()!=null){
            table.setName(request.getName());
        }
        if(!request.getTimeFrames().isEmpty()){
            table.getTimeFrames().clear();
            table.getTimeFrames().addAll(request.getTimeFrames());
        }

        analysisTableRepository.save(table);
        return TableMapper.toResponse(table);
    }
}
