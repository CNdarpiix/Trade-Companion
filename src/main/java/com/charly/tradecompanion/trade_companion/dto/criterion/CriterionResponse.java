package com.charly.tradecompanion.trade_companion.dto.criterion;

import lombok.Data;


@Data

public class CriterionResponse {

    private Long id ;

    private String name ;

    private Double coefficient ;

    private Long table ;
}
