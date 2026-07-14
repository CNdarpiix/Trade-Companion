package com.charly.tradecompanion.trade_companion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class TimeFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;

    private String timeFrame;

    private int coeficiant ;

}
