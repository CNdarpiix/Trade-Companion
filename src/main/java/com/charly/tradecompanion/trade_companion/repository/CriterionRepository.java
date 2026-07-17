package com.charly.tradecompanion.trade_companion.repository;

import com.charly.tradecompanion.trade_companion.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CriterionRepository extends JpaRepository<Criterion, Long> {
    List<Criterion> findByTableId(Long tableId);
}
