package com.charly.tradecompanion.trade_companion.dto.table;

import com.charly.tradecompanion.trade_companion.entity.TimeFrame;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class CreateTable {
    @NotBlank
    private String name;

    private List<TimeFrame> timeFrames = new ArrayList<>() ;


}
