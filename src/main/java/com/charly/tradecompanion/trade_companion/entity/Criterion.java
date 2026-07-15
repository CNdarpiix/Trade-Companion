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
    public Long id ;

    public String name ;

    public double coefficient ;

    @ManyToOne
    public AnalysisTable table ;
}
