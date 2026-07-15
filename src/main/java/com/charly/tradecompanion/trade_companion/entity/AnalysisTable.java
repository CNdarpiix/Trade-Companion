package com.charly.tradecompanion.trade_companion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class AnalysisTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private List<TimeFrame> timeFrames ;

    public AnalysisTable(){
        timeFrames = new ArrayList<>();
    }

}
