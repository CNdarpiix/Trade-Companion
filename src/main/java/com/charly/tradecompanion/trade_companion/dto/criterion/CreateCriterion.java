package com.charly.tradecompanion.trade_companion.dto.criterion;

import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateCriterion {
    @NotBlank
    private String name ;
    @Positive
    private Double coefficient ;
    @NotNull
    private Long table ;
}
