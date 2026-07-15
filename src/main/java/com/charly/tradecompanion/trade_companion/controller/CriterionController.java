package com.charly.tradecompanion.trade_companion.controller;

import com.charly.tradecompanion.trade_companion.dto.criterion.CreateCriterion;
import com.charly.tradecompanion.trade_companion.dto.criterion.CriterionResponse;
import com.charly.tradecompanion.trade_companion.service.CriterionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriterionController {
    private final CriterionService criterionService;

    public CriterionController(CriterionService criterionService) {
        this.criterionService = criterionService;
    }

    @PostMapping("/criterion")
    public CriterionResponse createCriterion(@Valid @RequestBody CreateCriterion request ){
        return criterionService.createCriterion(request);
    }

    @GetMapping("/criterion")
    public List<CriterionResponse> getAllCriterion(){
        return criterionService.getAllCriterion();
    }

    @GetMapping("/criterion/{id}")
    public CriterionResponse getCriterionById(@PathVariable Long id){
        return criterionService.getCriterionById(id);
    }

    @PutMapping("/criterion/{id}")
    public CriterionResponse putCriterion(@Valid @RequestBody CreateCriterion request ,@PathVariable Long id){
        return criterionService.putCriterion(request , id);
    }

    @DeleteMapping("/criterion/{id}")
    public CriterionResponse deleteCriterion(@PathVariable Long id){
        return criterionService.deleteCriterionById(id);
    }

}
