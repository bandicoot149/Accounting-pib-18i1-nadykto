package com.sibadi.model;

import java.util.HashMap;
import java.util.Map;

public enum Scores {
    PRODUCTS(41),
    CASHIER(50),
    SETTLEMENTS_SUPPLIERS(60),
    SETTLEMENTS_BUYERS(62),
    SALES(90);

    private int value;
    private static Map map = new HashMap<>();

    private Scores(int value) {
        this.value = value;
    }
    static {
        for (Scores score : Scores.values()) {
            map.put(score.value, score);
        }
    }

    public static Scores valueOf(int score) {
        return (Scores) map.get(score);
    }

    public int getValue() {
        return value;
    }
}
