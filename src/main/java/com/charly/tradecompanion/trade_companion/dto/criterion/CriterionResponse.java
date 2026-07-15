package com.charly.tradecompanion.trade_companion.dto.criterion;

import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CriterionResponse {

    private Long id ;

    private String name ;

    private Double coefficient ;

    private Long table ;
}
