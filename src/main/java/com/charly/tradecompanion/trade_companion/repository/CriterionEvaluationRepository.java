package com.charly.tradecompanion.trade_companion.repository;

import com.charly.tradecompanion.trade_companion.entity.CriterionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriterionEvaluationRepository extends JpaRepository<CriterionEvaluation, Long> {
    List<CriterionEvaluation> findByCriterionId(Long criterionId);
}
