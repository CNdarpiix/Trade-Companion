package com.charly.tradecompanion.trade_companion.dto.criterion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data

public class CreateCriterion {
    @NotBlank
    private String name ;
    @Positive
    private Double coefficient ;
    @NotNull
    private Long tableId ;
}
