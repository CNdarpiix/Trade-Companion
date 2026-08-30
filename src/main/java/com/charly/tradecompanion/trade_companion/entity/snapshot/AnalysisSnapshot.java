package com.charly.tradecompanion.trade_companion.entity.snapshot;

import com.charly.tradecompanion.trade_companion.entity.Criterion;
import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AnalysisSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL )
    private List<Criterion> criterion ;

    @OneToMany(cascade = CascadeType.ALL )
    private List<CriterionEvaluationSnapshot> criterionData ;

}
