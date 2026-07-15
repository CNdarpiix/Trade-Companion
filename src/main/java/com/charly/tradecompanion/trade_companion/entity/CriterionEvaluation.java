package com.charly.tradecompanion.trade_companion.entity;


import com.charly.tradecompanion.trade_companion.enums.AnalysisBias;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CriterionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    private TimeFrame timeFrame ;

    @ManyToOne
    private Criterion criterion;

    @Enumerated(EnumType.STRING)
    private AnalysisBias bias;
}
