package com.charly.tradecompanion.trade_companion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    private Double coefficient ;

    @ManyToOne
    private AnalysisTable table ;
}
