package com.charly.tradecompanion.trade_companion.dto.table;

import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateTable {
    private String name;

    private List<TimeFrame> timeFrames ;

}
