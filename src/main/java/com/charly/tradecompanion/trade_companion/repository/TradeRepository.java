package com.charly.tradecompanion.trade_companion.repository;

import com.charly.tradecompanion.trade_companion.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
}
