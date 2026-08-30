package com.charly.tradecompanion.trade_companion.repository;

import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeFrameRepository extends JpaRepository<TimeFrame , Long> {
}
