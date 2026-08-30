package com.charly.tradecompanion.trade_companion.entity.snapshot;

import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CriterionEvaluationSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @OneToMany
    private List<CriterionEvaluation> criterionEvaluationList;

}
